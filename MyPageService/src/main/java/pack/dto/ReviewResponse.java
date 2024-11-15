package pack.dto;

import lombok.Getter;
import pack.domain.Review;

@Getter
public class ReviewResponse {
	private final String hospitalName;
	private final String visitDate;
	private final Long rating;
	private final String text;
	
	public ReviewResponse(Review review) {
		this.hospitalName = review.getHospital().getHospitalName();
		this.visitDate = review.getVisitDate();
		this.rating = review.getRating();
		this.text = review.getText();
	}
}