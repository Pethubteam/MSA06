package pack.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Petowner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "petowner_id", updatable = false)
	private Long petownerId;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "phone", nullable = false)
    private String phone;
	
	@Column(name = "email", nullable = false)
    private String email;
	
	@Column(name = "address", nullable = false)
    private String address;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
