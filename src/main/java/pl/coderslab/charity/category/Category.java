package pl.coderslab.charity.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import pl.coderslab.charity.donation.Donation;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ElementCollection
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    Set<Donation> donations = new HashSet<>();

}
