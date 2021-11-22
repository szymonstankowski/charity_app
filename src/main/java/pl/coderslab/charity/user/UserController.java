package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.role.Role;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final DonationService donationService;



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/check")
    public String check(Principal principal) {
        if (userService.checkUser(userService.findUserByEmail(principal.getName()))) {
            return "redirect:/admin";
        }
        return "redirect:/donation";
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
