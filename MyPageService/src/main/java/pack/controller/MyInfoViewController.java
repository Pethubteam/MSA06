package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/myPage")
public class MyInfoViewController {

	@Autowired
	RestTemplate rt;
	
	@GetMapping("/myInfo/{userId}")
	public String myInfo(@PathVariable Long userId, Model model) {
		model.addAttribute("petowner", model);
		return "myInfo";
	}
}
