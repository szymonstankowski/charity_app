package pl.coderslab.charity.security;

import org.springframework.security.core.GrantedAuthority;
import pl.coderslab.charity.user.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final User user;


    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.charity.user.User user) {
        super(username, password, authorities);
        this.user=user;
    }
    public pl.coderslab.charity.user.User getUser(){return user;}

}
