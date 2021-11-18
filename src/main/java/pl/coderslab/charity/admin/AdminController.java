package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.institutions.InstitutionService;

@AllArgsConstructor
@Controller
public class AdminController {

    private final InstitutionService institutionService;


    @GetMapping("/admin")
    public String console(){
        return "admin";
    }
}
