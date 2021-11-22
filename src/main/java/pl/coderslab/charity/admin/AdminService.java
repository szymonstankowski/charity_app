package pl.coderslab.charity.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserServiceImpl userService;
    private final Integer DISABLE_USER = 1;
    private final Integer ENABLE_USER = 2;


    public void disableUser(Long id){
        User userById = userService.findUserById(id);
        userById.setActive(DISABLE_USER);
    }

    public void enableUser(Long id){
        User userById = userService.findUserById(id);
        userById.setActive(ENABLE_USER);
    }
}
