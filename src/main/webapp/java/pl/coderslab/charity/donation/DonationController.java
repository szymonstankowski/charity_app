package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;

import java.util.List;

@AllArgsConstructor
@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/donations")
    public String donationForm(Model model){
        model.addAttribute("donations", new Donation());
        return "form";
    }

    @PostMapping("/addDonation")
    public String addDonation(Donation donation, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/donations";
        }
        donationService.save(donation);
        return "form-confirmation";
    }


    //<form action="form-confirmation.html" method="post">
    @ModelAttribute("categories")
    public List<Category> categories (){
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions (){
        return institutionService.findAll();
    }
}
