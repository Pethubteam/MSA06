package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.domain.Review;
import pack.repository.MyReviewRepository;

@RequiredArgsConstructor
@Service
public class MyReviewService {
	
//	@Autowired
//    private MyReviewRepository myReviewRepository;
	private final MyReviewRepository myReviewRepository;

	public List<Review> findAll() {
		return myReviewRepository.findAll();
	}
	
//	public List<Review> getReviewsByPetOwnerId(Long petOwnerId) {
//        return myReviewRepository.findByPetownerId(petOwnerId);
//    }
	
	public Review findById(long reviewId) {
        return myReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + reviewId));
    }
}