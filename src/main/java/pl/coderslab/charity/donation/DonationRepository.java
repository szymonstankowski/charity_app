package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.user.User;

import java.util.List;

public interface DonationRepository extends JpaRepository <Donation, Long> {


    @Query(value = "SELECT SUM(quantity) FROM donation",nativeQuery = true)
    Integer itemsSum();

    @Query(value = "select count(*)from donation",nativeQuery = true)
    Integer allDonationsSum();

    List<Donation> findAllByUser(User user);



}
