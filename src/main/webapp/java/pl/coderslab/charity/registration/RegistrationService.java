package pl.coderslab.charity.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserService;

@Service
public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user){
        user.setRole("ROLE_USER");
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userService.saveUser(user);
    }


}
