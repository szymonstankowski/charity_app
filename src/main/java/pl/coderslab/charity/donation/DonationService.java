package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }

    public Integer itemsSum() {
        return donationRepository.itemsSum();
    }

    public Integer allDonationsSum() {
        return donationRepository.allDonationsSum();
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    public List<Donation> getDonationsByUser(User user) {
        return donationRepository.findAllByUser(user);
    }

}
