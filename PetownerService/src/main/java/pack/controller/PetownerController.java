package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pack.domain.Petowner;
import pack.service.PetownerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/myInfo")
public class PetownerController {
	
	@Autowired
	PetownerService petownerService;
	
	@GetMapping("")
	public List<Petowner> myInfo() {
		List<Petowner> result = petownerService.findAll();
		return result;
	}
}
