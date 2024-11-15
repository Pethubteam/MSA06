package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pack.domain.Review;

@Repository
public interface MyReviewRepository extends JpaRepository<Review, Long> {

//	List<Review> findByPetownerId(Long petOwnerId);
}