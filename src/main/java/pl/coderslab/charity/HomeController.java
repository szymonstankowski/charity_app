package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;

import java.util.List;

@AllArgsConstructor
@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;


    @RequestMapping("/home")
    public String homeAction(Model model){

        List<Donation> donations = donationService.getDonations();


        model.addAttribute("institutions",institutionService.getInstitutions());
        model.addAttribute("donations",donations.size());



        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model){
        return "about";
    }


}
