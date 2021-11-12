package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



public interface UserService {

    void saveUser(User user);

    User findUserByUserName(String userName);
}
