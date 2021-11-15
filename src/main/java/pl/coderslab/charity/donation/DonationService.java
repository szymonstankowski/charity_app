package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public List<Donation> getDonations(){
        return donationRepository.findAll();
    }

    public Integer itemsSum(){
        return donationRepository.itemsSum();
    }

    public void save(Donation donation){

        donationRepository.save(donation);
    }
}
