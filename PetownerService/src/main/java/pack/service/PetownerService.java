package pack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.repository.PetownerRepository;

@RequiredArgsConstructor
@Service
public class PetownerService {
	
	private final PetownerRepository petownerRepository;
	
	public List<Petowner> findAll() {
		return petownerRepository.findAll();
	}
}
