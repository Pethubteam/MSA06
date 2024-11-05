package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/myPage")
public class MyInfoViewController {

	@Autowired
	RestTemplate rt;
	
	@GetMapping("/myInfo")
	public String myInfo() {
		String result = rt.getForObject(
				"http://PetownerService/myInfo",
				String.class);
		return result;
	}
}
