package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hospitalName;
    private String address;
    private String phoneNumber;
    private String operatingHours;
    private double lat;
    private double lng;
    private String imagePath;

    // Getters and Setters
}
