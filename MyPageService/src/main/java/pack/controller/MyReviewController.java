package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import pack.domain.Review;
import pack.dto.ReviewListViewResponse;
import pack.dto.ReviewViewResponse;
import pack.service.MyReviewService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage")
public class MyReviewController {
	
	@Autowired
	MyReviewService myReviewService;
	
	@GetMapping("")
	public String myPage() {
		return "myPage";
	}
	
	// =====================================================================
	
	@GetMapping("/myReviews")
	public String myReviewList(Model model) {
		List<ReviewListViewResponse> reviews = myReviewService.findAll()
				.stream()
                .map(ReviewListViewResponse::new)
                .toList();

        model.addAttribute("reviews", reviews);
		return "myReviewList";
	}
	
	@GetMapping("/myReviews/{reviewId}")
	public String myReviews(@PathVariable Long reviewId, Model model) {
		Review review = myReviewService.findById(reviewId);
        model.addAttribute("review", new ReviewViewResponse(review));
		return "myReview";
	}
	
	@GetMapping("/addReview")
	public String addReview(@RequestParam(required = false) Long reviewId, Model model) {
		if (reviewId == null) {
			model.addAttribute("review", new ReviewViewResponse());
		} else {
			Review review = myReviewService.findById(reviewId);
			model.addAttribute("review", new ReviewViewResponse(review));
		}
		return "addReview";
	}
	
	// =====================================================================
	
	@GetMapping("/myLikeHospital")
	public String myLikeHospital() {
		return "myLikeHospital";
	}
	
}