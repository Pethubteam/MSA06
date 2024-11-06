package pack.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PetownerDTO {
    private Long petownerId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String password;
}

