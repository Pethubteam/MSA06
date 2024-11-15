package pack.dto;

import lombok.Getter;
import pack.domain.Review;

@Getter
public class ReviewListViewResponse {
	private final Long reviewId;
	private final Long petownerId;
	private final String hospitalName;
	private final Long rating;
	private final String text;
	private final String visitDate;
	
	public ReviewListViewResponse(Review review) {
		this.reviewId = review.getReviewId();
		this.petownerId = review.getPetownerId();
		this.hospitalName = review.getHospital().getHospitalName();
		this.rating = review.getRating();
		this.text = review.getText();
		this.visitDate = review.getVisitDate();
	}
}