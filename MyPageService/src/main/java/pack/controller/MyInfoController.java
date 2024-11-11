//package pack.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import lombok.RequiredArgsConstructor;
//import pack.dto.PetownerDTO;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/myPage")
//public class MyInfoController {
//
//	@Autowired
//	RestTemplate rt;
//	
//	@GetMapping("/myInfo/{petownerId}")
//	public String myInfo(@PathVariable Long petownerId, Model model) {
//		String petownerServiceUrl = "http://PetownerService/myInfo/" + petownerId;
//
//        // RestTemplate을 사용하여 PetownerService에서 PetOwner 데이터 가져오기
//        PetownerDTO petowner = rt.getForObject(petownerServiceUrl, PetownerDTO.class);
//
//        // 가져온 PetOwner 데이터를 "petowner"라는 이름으로 모델에 추가
//        model.addAttribute("petowner", petowner);
//
//		return "myInfo";
//	}
//}
