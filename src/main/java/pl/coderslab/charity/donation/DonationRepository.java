package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository <Donation, Long> {


    @Query(value = "SELECT SUM(quantity) FROM donation",nativeQuery = true)
    Integer itemsSum();

    @Query(value = "select count(*)from donation",nativeQuery = true)
    Integer allDonationsSum();



}
