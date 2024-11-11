package pack.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.domain.Petowner;

@NoArgsConstructor
@Getter
public class PetownerViewResponse {
	private Long petownerId;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String password;
	
	public PetownerViewResponse(Petowner petowner) {
		this.petownerId = petowner.getPetownerId();
		this.name = petowner.getName();
		this.phone = petowner.getPhone();
		this.email = petowner.getEmail();
		this.address = petowner.getAddress();
		this.password = petowner.getPassword();
	}
}
