package pl.coderslab.charity.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final static String USER_NOT_FOUND_EX = "User %s is not found!";

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);


    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByName(userName).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EX, userName)));
    }
}
