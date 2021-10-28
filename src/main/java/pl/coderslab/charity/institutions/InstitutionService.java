package pl.coderslab.charity.institutions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public void addInstitution(Institution institution) {
        institutionRepository.save(institution);
    }


    public List<Institution> getInstitutions(){
        return institutionRepository.findAll();
    }
}
