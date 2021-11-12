package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "User %s not found";

    private final UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findUserByName(String userName){

        return userRepository.findUserByName(userName).orElse(null);
    }
}
