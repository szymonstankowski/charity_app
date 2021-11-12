package pl.coderslab.charity.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;

@Component
@AllArgsConstructor
public class CategoryConverter implements
        org.springframework.core.convert.converter.Converter <String, Category> {

    private final CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.findById(Long.parseLong(s));
    }

}
