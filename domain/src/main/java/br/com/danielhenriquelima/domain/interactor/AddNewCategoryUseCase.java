package br.com.danielhenriquelima.domain.interactor;

import br.com.danielhenriquelima.domain.boundary.BoundaryIn;
import br.com.danielhenriquelima.domain.exception.AddNewCategoryException;
import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.repository.CategoryRepository;

public class AddNewCategoryUseCase implements BoundaryIn<Category> {

    private CategoryRepository categoryRepository;

    public AddNewCategoryUseCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(Category category, Callback callback) {

        try {
            categoryRepository.createCategory(category);
            callback.onSuccess();
        }catch (AddNewCategoryException e){
            callback.onError(new AddNewCategoryException(e.getMessage()));
        }
    }
}
