package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.dto.PetownerDTO;
import pack.service.PetownerService;

@RequiredArgsConstructor
@Controller
public class PetownerController {
	
	private final PetownerService petownerService;
	
	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	
//	@PostMapping("/signup")
//	public String singup(@ModelAttribute PetownerDTO petownerDTO) {
//		petownerService.signup(petownerDTO);
//		return "login";
//	}
}
