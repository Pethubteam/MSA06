package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.dto.PetownerViewResponse;
import pack.service.PetownerService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage/myInfo")
public class MyInfoController {
	
	@Autowired
	PetownerService petownerService;
	
//	@GetMapping("")
//	public String myInfo() {
//		return "myInfo";
//	}
	
//	@GetMapping("/{petownerId}")
//	public String myInfo(@PathVariable Long petownerId, Model model) {
//		Petowner petowner = petownerService.findById(petownerId);
//		model.addAttribute("petowner", new PetownerViewResponse(petowner));
//		return "myInfo";
//	}
}
