package pl.coderslab.charity.institutions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query(value = "select * from institution where enable =1",nativeQuery = true)
    List<Institution> findEnabled();




}
