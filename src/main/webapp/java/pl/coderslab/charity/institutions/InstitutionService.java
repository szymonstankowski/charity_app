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


    public Institution findById(Long id){
        return institutionRepository.findById(id).orElse(null);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}
