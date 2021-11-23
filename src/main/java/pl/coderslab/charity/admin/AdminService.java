package pl.coderslab.charity.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserServiceImpl;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserServiceImpl userService;
    private final InstitutionService institutionService;
    private final Integer DISABLE = 0;
    private final Integer ENABLE = 1;


    public void disableUser(Long id){
        User userById = userService.findUserById(id);
        userById.setActive(DISABLE);
        userService.updateUser(userById);
    }

    public void enableUser(Long id){
        User userById = userService.findUserById(id);
        userById.setActive(ENABLE);
        userService.updateUser(userById);
    }

    public void disableInstitution(Long id){
        Institution institution = institutionService.findById(id);
        institution.setActive(DISABLE);
        institutionService.updateInstitution(institution);
    }

    public void enableInstitution(Long id){
        Institution institution = institutionService.findById(id);
        institution.setActive(ENABLE);
        institutionService.updateInstitution(institution);
    }


}
