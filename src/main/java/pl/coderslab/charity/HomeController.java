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
    public String homeAction(){
        return "index";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs(){
        return "aboutUs";
    }

    @RequestMapping("/institutions")
    public String institutions(){
        return "institutions";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "kontakt";
    }

    @ModelAttribute
    public void donations(Model model){
        //todo dla sum zrobic jedno zapytanie ktore bedzie liczylo count z bazy a nie zaciagalo baze do listy
        model.addAttribute("donations",donationService.getDonations().size());
        model.addAttribute("institutions",institutionService.findAll());
        Integer sum = donationService.itemsSum();
        model.addAttribute("itemsSum",sum );
    }



}
