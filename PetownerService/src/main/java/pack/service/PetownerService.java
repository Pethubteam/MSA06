//package pack.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import lombok.RequiredArgsConstructor;
//import pack.domain.Petowner;
//import pack.dto.SignupRequest;
//import pack.repository.PetownerRepository;
//
//@RequiredArgsConstructor
//@Service
//public class PetownerService {
//	
////	private final PetownerRepository petownerRepository;
//	@Autowired
//	private PetownerRepository petownerRepository;
//	
//	public Petowner findById(Long petownerId) {
////		return petownerRepository.findById(petownerId);
//		return petownerRepository.findById(petownerId)
//				.orElseThrow(() -> new IllegalArgumentException("not found: " + petownerId));
//	}
//	
//	public void registerUser(SignupRequest signupRequest) {
//        Petowner petowner = new Petowner();
//        petowner.setName(signupRequest.getName());
//        petowner.setPassword(signupRequest.getPassword()); // 비밀번호 암호화 필요
//        petowner.setPhone(signupRequest.getPhone());
//        petowner.setEmail(signupRequest.getEmail());
//        petowner.setAddress(signupRequest.getAddress());
//        petownerRepository.save(petowner);
//    }
//	
//	public Petowner authenticateUser(String email, String password) {
//	    Petowner petowner = petownerRepository.findByEmail(email);
//	    if (petowner != null && petowner.getPassword().equals(password)) { // 실제로는 비밀번호 암호화 비교 필요
//	        return petowner;
//	    }
//	    return null;
//	}
//
//}
