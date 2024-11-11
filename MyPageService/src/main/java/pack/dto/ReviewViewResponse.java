package pack.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.domain.Review;

@NoArgsConstructor
@Getter
public class ReviewViewResponse {
	private Long reviewId;
	private Long petownerId;
	private String hospitalName;
	private Long rating;
	private String text;
	private String visitDate;
	private Boolean verified;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public ReviewViewResponse(Review review) {
	    this.reviewId = review.getReviewId();
	    this.petownerId = review.getPetownerId();
	    this.hospitalName = review.getHospital().getHospitalName();
	    this.rating = review.getRating();
	    this.text = review.getText();
	    this.visitDate = review.getVisitDate();
	    this.verified = review.getVerified();
	    this.createdAt = review.getCreatedAt();
	    this.updatedAt = review.getUpdatedAt();
	}
}