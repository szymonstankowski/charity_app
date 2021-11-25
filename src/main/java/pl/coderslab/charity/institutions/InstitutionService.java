package pl.coderslab.charity.institutions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final Integer ENABLE = 1;



    public void addInstitution(Institution institution) {
        institution.setEnable(ENABLE);
        institutionRepository.save(institution);
    }


    public Institution findById(Long id){
        return institutionRepository.findById(id).orElse(null);
    }

    public List<Institution> findAllActive() {
        return institutionRepository.findEnabled();
    }

    public List<Institution> findAll(){
        return institutionRepository.findAll();
    }

    public void updateInstitution(Institution institution){
        institutionRepository.save(institution);

    }

}
