package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.repository.PetownerRepository;

@RequiredArgsConstructor
@Service
public class PetownerService {
	
//	private final PetownerRepository petownerRepository;
	@Autowired
	PetownerRepository petownerRepository;
	
	public Petowner findById(Long petownerId) {
//		return petownerRepository.findById(petownerId);
		return petownerRepository.findById(petownerId)
				.orElseThrow(() -> new IllegalArgumentException("not found: " + petownerId));
	}
	
	
}
