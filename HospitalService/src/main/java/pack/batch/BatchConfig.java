package pack.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import pack.entity.Hospital;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final DataSource dataSource;

    @Autowired
    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager, DataSource dataSource) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.dataSource = dataSource;
    }

    // 1. CSV 파일에서 데이터를 읽어오는 ItemReader 설정
    @Bean
    public FlatFileItemReader<Hospital> reader() {
        FlatFileItemReader<Hospital> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("/Users/starlike_yejin/Downloads/위도경도다있는동물병원데이터3.csv"));
        reader.setLinesToSkip(1); // 첫 줄은 헤더이므로 스킵

        DefaultLineMapper<Hospital> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        // CSV 컬럼과 Hospital 엔티티 필드 매핑
        tokenizer.setNames("번호", "소재지전화", "소재지전체주소", "Latitude", "Longitude", "사업장명");

        BeanWrapperFieldSetMapper<Hospital> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Hospital.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSet -> {
            Hospital hospital = new Hospital();
            hospital.setHospitalName(fieldSet.readString("사업장명"));
            hospital.setAddress(fieldSet.readString("소재지전체주소"));
            hospital.setPhoneNumber(fieldSet.readString("소재지전화"));

            // 위도와 경도를 읽을 때, 값이 없거나 잘못된 경우 기본값을 설정
            try {
                hospital.setLat(fieldSet.readDouble("Latitude"));
            } catch (NumberFormatException e) {
                hospital.setLat(0.0); // 기본값 설정
            }

            try {
                hospital.setLng(fieldSet.readDouble("Longitude"));
            } catch (NumberFormatException e) {
                hospital.setLng(0.0); // 기본값 설정
            }

            return hospital;
        });

        reader.setLineMapper(lineMapper);

        return reader;
    }


    

    // 2. DB에 데이터를 저장하는 ItemWriter 설정
    @Bean
    public JdbcBatchItemWriter<Hospital> writer() {
        return new JdbcBatchItemWriterBuilder<Hospital>()
                .dataSource(dataSource)
                .sql("INSERT INTO hospital (hospital_name, address, phone_number, operating_hours, lat, lng, image_path) " +
                     "VALUES (:hospitalName, :address, :phoneNumber, :operatingHours, :lat, :lng, :imagePath)")
                .beanMapped()
                .build();
    }


    // Step 설정: 데이터를 읽고 쓰는 단계를 정의
    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Hospital, Hospital>chunk(10, transactionManager)
                .reader(reader())
                .writer(writer())
                .build();
    }

    // Job 설정: 배치 작업의 전체 흐름 정의
    @Bean
    public Job importHospitalJob() {
        return new JobBuilder("importHospitalJob", jobRepository)
                .start(step1())
                .build();
    }
}
