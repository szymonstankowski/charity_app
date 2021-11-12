package pl.coderslab.charity.converter;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.institutions.Institution;
import pl.coderslab.charity.institutions.InstitutionService;

@AllArgsConstructor
@Component
public class InstitutionConverter implements Converter <String, Institution> {

    private final InstitutionService institutionService;

    @Override
    public Institution convert(String s) {
        return institutionService.findById(Long.parseLong(s));
    }
}
