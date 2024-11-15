package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.domain.Hospital;
import pack.domain.Review;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReviewRequest {
	private String hospitalName;
	private String visitDate;
	private Long rating;
	private String text;
	
	public Review toEntity(Hospital hospital) {
		return Review.builder()  // domain >> Review.java
				.hospital(hospital)
				.visitDate(visitDate)
				.rating(rating)
				.text(text)
				.build();
	}
}