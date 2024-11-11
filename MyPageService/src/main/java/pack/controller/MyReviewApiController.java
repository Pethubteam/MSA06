//package pack.controller;
//
//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//import pack.domain.Review;
//import pack.dto.ReviewResponse;
//import pack.service.MyReviewService;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/myPage")
//public class MyReviewApiController {
//
//	private final MyReviewService myReviewService;
//	
//	@GetMapping("/myReviews")
//	public ResponseEntity<List<ReviewResponse>> findAllReviews() {
//		System.out.println("Api컨트롤러 - findAll");
//		List<ReviewResponse> reviews = myReviewService.findAll()
//				.stream()
//				.map(ReviewResponse::new)
//                .toList();
//        return ResponseEntity.ok()
//                .body(reviews);
//	}
//	
//	@GetMapping("/myReviews/{reviewId}")    // {reviewId}에 숫자넣으면 됨   ==>  @PathVariable
//    public ResponseEntity<ReviewResponse> findReview(@PathVariable long reviewId) {    
//		System.out.println("Api컨트롤러 - findById");
//        Review review = myReviewService.findById(reviewId);
//        return ResponseEntity.ok()
//                .body(new ReviewResponse(review));
//    }
//}
