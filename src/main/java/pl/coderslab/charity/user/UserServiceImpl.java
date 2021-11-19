package pl.coderslab.charity.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByName(userName).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EX, userName)));
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_EX, email)));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> userList(){
        return userRepository.getUsers();
    }

    public List<User> adminList(){
        return userRepository.getAdmins();
    }

}
