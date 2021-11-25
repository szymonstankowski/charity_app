package pl.coderslab.charity.institutions;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Institution {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer enable;


}
