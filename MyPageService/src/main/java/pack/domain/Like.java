package pack.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_id", updatable = false)
	private Long likeId;
	
	@Column(name = "petowner_id", nullable = false)
	private Long petownerId;
	
	@Column(name = "hospital_id", nullable = false)
	private Long hospitalId;
	
	// --------------------------------------------------
	
//	// 사용자 이름
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "petowner_id", nullable = false)
//	private Petowner petowner;
//	
//	// 병원 이름
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "hospital_id", nullable = false)
//    private Hospital hospital;
}
