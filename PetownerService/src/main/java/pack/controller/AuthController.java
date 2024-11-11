package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import pack.domain.Petowner;
import pack.dto.LoginRequest;
import pack.dto.PetownerDTO;
import pack.dto.SignupRequest;
import pack.service.PetownerService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private PetownerService petownerService;

//    @PostMapping("/signup")
//    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
//        try {
//            petownerService.registerUser(signupRequest);
//            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error registering user");
//        }
//    }
    
//    public String register(@RequestBody PetownerDTO petOwnerInfo) {
//        return petownerService.register(petOwnerInfo) ? "Registration successful" : "Username already exists";
//    }
    
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
//        Petowner petowner = petownerService.authenticate(loginRequest.getName(), loginRequest.getPassword());
//        if (petowner != null) {
//            // 로그인 성공 시, 세션에 userId 저장
//            session.setAttribute("petownerId", petowner.getPetownerId());
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
}