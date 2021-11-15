package pl.coderslab.charity.user;


public interface UserService {

    void createUser(User user);

    User findUserByUserName(String userName);

    User findUserByEmail(String email);
}
