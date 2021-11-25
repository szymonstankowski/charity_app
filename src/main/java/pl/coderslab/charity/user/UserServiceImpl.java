package pl.coderslab.charity.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.exception.ApiRequestException;
import pl.coderslab.charity.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final Integer ACTIVE = 1;
    private final static String USER_NOT_FOUND_EX = "User %s is not found!";

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        user.setActive(ACTIVE);
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByName(userName).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EX, userName)));
    }

    @Override
    public User findUserByEmail(String email) {
      return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EX, email)));


    }
    public boolean checkUserAdmin(User user){
           return user.getRoles().stream()
                .anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
    }

    public User findActiveUser(User user){
        if (user.getActive().equals(1)){
            return user;
        }else {
            throw new ApiRequestException("User zablokowany");
        }

    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }


    public List<User> userList(){
        return userRepository.getUsers();
    }

    public List<User> adminList(){
        return userRepository.getAdmins();
    }

}
