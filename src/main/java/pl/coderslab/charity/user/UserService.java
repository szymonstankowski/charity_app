package pl.coderslab.charity.user;


import java.util.List;

public interface UserService {

    void createUser(User user);

    User findUserByUserName(String userName);

    User findUserByEmail(String email);

    User findUserById(Long id);




}
