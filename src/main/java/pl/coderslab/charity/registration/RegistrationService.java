package pl.coderslab.charity.registration;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

@Service
public class RegistrationService {

    private final UserServiceImpl userService;

    public RegistrationService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void register(User user){
        userService.createUser(user);
    }

}
