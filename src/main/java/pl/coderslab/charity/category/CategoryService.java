package pl.coderslab.charity.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
