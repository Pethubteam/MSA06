package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage/myInfo")
public class MyInfoController {
	
	@GetMapping("")
	public String myInfo() {
		return "myInfo";
	}
}
