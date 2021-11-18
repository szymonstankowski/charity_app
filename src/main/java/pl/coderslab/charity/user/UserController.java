package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.role.Role;

import java.security.Principal;
import java.util.Set;

@Controller
@AllArgsConstructor
public class UserController{

    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/check")
    public String check(Principal principal){
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        //TODO zamienic na stream??
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.getName().equals("ROLE_ADMIN")){
                return "redirect:/admin";
            }
        }return "redirect:/donation";
    }
}
