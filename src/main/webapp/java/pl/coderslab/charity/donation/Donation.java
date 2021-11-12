package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institutions.Institution;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinColumn(name = "category_id")
    List<Category> categories = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "institution_id")
    Institution institution;


    private Integer quantity;
    private String street;
    private String city;
    @Size(max = 7)
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;
    @Size(max = 300)
    private String pickUpComment;



}
