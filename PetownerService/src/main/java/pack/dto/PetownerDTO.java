package pack.dto;

import lombok.Getter;
import lombok.Setter;
import pack.domain.Petowner;

@Setter
@Getter
public class PetownerDTO {
	private String name;
    private String phone;
    private String email;
    private String address;
    private String password;
    
    public void PetOwnerResponse(Petowner petowner) {
    	this.name = petowner.getName();
    	this.phone = petowner.getPhone();
    	this.email = petowner.getEmail();
    	this.address = petowner.getAddress();
    	this.password = petowner.getPassword();
    }
}
