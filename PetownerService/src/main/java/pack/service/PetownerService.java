package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.dto.PetownerDTO;
import pack.dto.SignupRequest;
import pack.repository.PetownerRepository;

@RequiredArgsConstructor
@Service
public class PetownerService {
	
	@Autowired
	private PetownerRepository petownerRepository;
	
//	public void signup(PetownerDTO petownerDTO) {
//		Petowner petowner = Petowner.
//	}

}
