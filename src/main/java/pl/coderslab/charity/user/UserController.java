package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.donation.Donation;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class UserController{
    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    //todo dlaczego po logowaniu dostaje blad login?error

//    @GetMapping("/userprofile")
//    public String userprofile(Model model, Principal principal){
//        User userByEmail = userService.findUserByEmail(principal.getName());
//        model.addAttribute("user", userByEmail);
//        model.addAttribute("donation", new Donation());
//        return "form";
//    }
}
