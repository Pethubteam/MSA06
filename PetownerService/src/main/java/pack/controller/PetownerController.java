//package pack.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//import pack.domain.Petowner;
//import pack.service.PetownerService;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/myInfo")
//public class PetownerController {
//	
//	@Autowired
//	PetownerService petownerService;
//	
//	@GetMapping("/{petownerId}")
//	public ResponseEntity<Petowner> getPetOwnerById(@PathVariable Long petownerId) {
//        Petowner petowner = petownerService.findById(petownerId);
//        return ResponseEntity.ok(petowner);
//    }
//}
