package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyPageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPageServiceApplication.class, args);
	}

}
