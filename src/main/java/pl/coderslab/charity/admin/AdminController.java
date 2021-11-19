package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private final InstitutionService institutionService;
    private final UserServiceImpl userService;


    @GetMapping("/admin")
    public String console(){
        return "admin";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @GetMapping("/adminInstitutions")
    public String institutions(Model model){
        List<Institution> allInstitutions = institutionService.findAll();
        model.addAttribute(allInstitutions);
        return "admin-institutions";
    }

    //TODO napisac ustawianie Usera na NOT ACTIVE ALBO DISABLED





}
