package pack.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id", updatable = false)
	private Long reviewId;
	
	@Column(name = "petowner_id", nullable = false)
	private Long petownerId;
	
	// 병원 이름
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;
	
	@Column(name = "rating", nullable = false)
	private Long rating;
	
	@Column(name = "text", nullable = false)
	private String text;
	
	@Column(name = "visit_date", nullable = false)
	private String visitDate;
	
	@Column(name = "verified", nullable = false)
	private Boolean verified;
	
	@CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Builder
    public Review(Hospital hospital, String visitDate, Long rating, String text) {
        this.hospital = hospital;
        this.visitDate = visitDate;
        this.rating = rating;
        this.text = text;
    }
    
//    public void update(Long rating, String text) {
//        this.rating = rating;
//        this.text = text;
//    }
}
