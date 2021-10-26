package pl.coderslab.charity.institutions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public void addInstitution(Institution institution) {
        institutionRepository.save(institution);
    }
}
