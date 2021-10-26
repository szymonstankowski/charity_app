package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institutions.Institution;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    Category categories;
    Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;



}
