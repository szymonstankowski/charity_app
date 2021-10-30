package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class DonationController {

    private final DonationService donationService;


    @RequestMapping("/donations")
    public String donationForm(Donation donation, Model model){
        model.addAttribute("donation", donation);
        return "donation-form";
    }
}
