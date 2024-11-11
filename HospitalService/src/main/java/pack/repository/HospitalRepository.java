package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pack.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // 병원에 대한 기본적인 CRUD 메서드는 JpaRepository에서 제공
}
