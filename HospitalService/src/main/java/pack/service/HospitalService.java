package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.entity.Hospital;
import pack.repository.HospitalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    // 모든 병원 목록 가져오기
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    // 특정 병원 ID로 병원 정보 가져오기
    public Optional<Hospital> getHospitalById(Long id) {
        return hospitalRepository.findById(id);
    }
}