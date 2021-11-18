package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("donations",donationService.allDonationsSum());
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("itemsSum",donationService.itemsSum() );
        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("donations",donationService.allDonationsSum());
        model.addAttribute("itemsSum",donationService.itemsSum() );
        return "about";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs(){
        return "aboutUs";
    }

    @RequestMapping("/institutions")
    public String institutions(Model model){
        model.addAttribute("donations",donationService.allDonationsSum());
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("itemsSum",donationService.itemsSum());
        return "institutions";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "kontakt";
    }
}
