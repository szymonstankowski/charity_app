package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final DonationService donationService;



    @GetMapping("/login")
    public String login() {
        return "login";
    }


    //todo jak lepiej obsluzyc ten wyjatek
    @GetMapping("/check")
    public String check(Principal principal){

        User activeUser = userService.findActiveUser(userService.findUserByEmail(principal.getName()));
        if (userService.checkUserAdmin(activeUser)) {
            return "redirect:/admin";
        }

        return "redirect:/donation";
    }
    @GetMapping("/error")
    @ResponseBody
    public String userBlocked(){
        return "Uzytkownik zablokowany";
    }

    @GetMapping("/userdonations")
    public String userdonations(Principal principal, Model model){
        String email = principal.getName();
        User userByEmail = userService.findUserByEmail(email);
        List<Donation> donationsByUser = donationService.getDonationsByUser(userByEmail);

        model.addAttribute("donations", donationsByUser);
        return "user-donations-list";
    }
}
