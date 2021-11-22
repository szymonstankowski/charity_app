package pl.coderslab.charity.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import pl.coderslab.charity.role.Role;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Set;


@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @Email
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    private Integer active;


    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    }

    public User() {

    }
}
