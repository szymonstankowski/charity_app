package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institutions.Institution;

import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public List<Donation> getDonations(){
        return donationRepository.findAll();
    }

    public int itemsSum(){
        return donationRepository.itemsSum();
    }

    public void save(Donation donation){

        donationRepository.save(donation);
    }
}
