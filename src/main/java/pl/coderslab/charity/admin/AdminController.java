package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private final InstitutionService institutionService;
    private final UserServiceImpl userService;
    private final AdminService adminService;


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
    @GetMapping("/disableUser/{id}")
    public String disableUser(@PathVariable Long id){
        adminService.disableUser(id);
        return "redirect:/users";
    }

    @GetMapping("/enableUser/{id}")
    public String enableUser(@PathVariable Long id){
        adminService.enableUser(id);
        return "redirect:/users";
    }

    @GetMapping("/adminInstitutions")
    public String institutions(Model model){
        List<Institution> institutions = institutionService.findAll();
        model.addAttribute("institutions", institutions);
        return "admin-institutions";
    }
    @GetMapping("/disableInstitution/{id}")
    public String disableInstitution(@PathVariable Long id){
        adminService.disableInstitution(id);
        return "redirect:/adminInstitutions";
    }

    @GetMapping("/enableInstitution/{id}")
    public String enableInstitution(@PathVariable Long id){
        adminService.enableInstitution(id);
        return "redirect:/adminInstitutions";
    }

    @GetMapping("/addNewInstitution")
    public String addNewInstitution(Model model){
        model.addAttribute("institution", new Institution());
        return "add-institution-form";
    }

    @PostMapping("/addNewInstitution")
    public String createNewInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "add-institution-form";
        }
        institutionService.addInstitution(institution);
        return "redirect:/adminInstitutions";
    }






}
