package pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.dto.PetownerDTO;
import pack.repository.PetownerRepository;

@RequiredArgsConstructor
@Service
public class PetownerService {
	
	@Autowired
	private PetownerRepository petownerRepository;

	public PetownerDTO findById(Long petownerId) {
		Optional<Petowner> optionalPetowner = petownerRepository.findById(petownerId);
		if (optionalPetowner.isPresent()) {
			return PetownerDTO.toPetownerDTO(optionalPetowner.get());
		}
		else {
			return null;
		}
	}
	
	// ------------------------------------------------------------------
	
	public void signup(PetownerDTO petownerDTO) {
		Petowner petowner = Petowner.toPetownerEntity(petownerDTO);
		petownerRepository.save(petowner);
	}

	public PetownerDTO login(PetownerDTO petownerDTO) {
		Optional<Petowner> byEmail = petownerRepository.findByEmail(petownerDTO.getEmail());
		if (byEmail.isPresent()) {    // 해당 이메일 있음
			Petowner petowner = byEmail.get();
			if (petowner.getPassword().equals(petownerDTO.getPassword())) {    // 비밀번호 일치
				PetownerDTO petownerDTO2 = PetownerDTO.toPetownerDTO(petowner);
				return petownerDTO2;
			}
			else {    // 비밀번호 다름
				return null;
			}
		}
		else {    // 해당 이메일 없음
			return null;
		}
	}
	
	public PetownerDTO updateForm(String petownerEmail) {
		Optional<Petowner> optionalPetowner = petownerRepository.findByEmail(petownerEmail);
		if (optionalPetowner.isPresent()) {
			return PetownerDTO.toPetownerDTO(optionalPetowner.get());
		} 
		else {
			return null;
		}
	}
	
	public void update(PetownerDTO petownerDTO) {
		petownerRepository.save(Petowner.toUpdatePetownerEntity(petownerDTO));
	}
	
	public String emailCheck(String petownerEmail) {    // 이메일 중복 검사
		Optional<Petowner> byEmail = petownerRepository.findByEmail(petownerEmail);
		if (byEmail.isPresent()) {
			return null;
		}
		else {
			return "ok";
		}
	}
}
