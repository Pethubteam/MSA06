package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
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
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute PetownerDTO petownerDTO) {
//		System.out.println("petownerDTO = " + petownerDTO);
		petownerService.signup(petownerDTO);
		return "login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute PetownerDTO petownerDTO, HttpSession session) {
		PetownerDTO loginResult = petownerService.login(petownerDTO);
		if (loginResult != null) {    // 로그인 성공
			session.setAttribute("loginEmail", loginResult.getEmail());
			return "main";
		}
		else {    // 로그인 실패
			return "login";
		}
	}
	
	@GetMapping("/{petownerId}")
	public String findById(@PathVariable Long petownerId, Model model) {
		PetownerDTO petownerDTO = petownerService.findById(petownerId);
		model.addAttribute("petowner", petownerDTO);
		return "myInfo";
	}
	
	@GetMapping("/update")
	public String updateForm(HttpSession session, Model model) {
		String petownerEmail = (String) session.getAttribute("loginEmail");
		PetownerDTO petownerDTO = petownerService.updateForm(petownerEmail);
		model.addAttribute("updatePetowner", petownerDTO);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute PetownerDTO petownerDTO) {
		petownerService.update(petownerDTO);
		return "redirect:/" + petownerDTO.getPetownerId();
	}
	
	@PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("email") String petownerEmail) {
        System.out.println("petownerEmail = " + petownerEmail);
        String checkResult = petownerService.emailCheck(petownerEmail);
        return checkResult;
    }
}
