package pl.coderslab.charity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserService;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userService.findUserByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        user.getRoles().forEach(r ->
//                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
//        return new CurrentUser(user.getEmail(),user.getPassword(),
//                grantedAuthorities, user);
//    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(userEmail);
        if (user == null) {
            throw new UsernameNotFoundException(userEmail);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

}
