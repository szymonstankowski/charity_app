package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institutions.InstitutionService;

@AllArgsConstructor
@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("donations",donationService.getDonations().size());
        Integer sum = donationService.itemsSum();
        model.addAttribute("itemsSum",sum );
        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("donations",donationService.getDonations().size());
        Integer sum = donationService.itemsSum();
        model.addAttribute("itemsSum",sum );
        return "about";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs(){
        return "aboutUs";
    }

    @RequestMapping("/institutions")
    public String institutions(Model model){
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("donations",donationService.getDonations().size());
        Integer sum = donationService.itemsSum();
        model.addAttribute("itemsSum",sum );
        return "institutions";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }




}
