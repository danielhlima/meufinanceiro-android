package br.com.danielhenriquelima.domain.interactor;

import java.util.List;

import br.com.danielhenriquelima.domain.exception.GetAllCategoriesException;
import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.repository.CategoryRepository;

public class GetAllCategoriesUseCase implements UseCaseOut {

    private CategoryRepository categoryRepository;

    public GetAllCategoriesUseCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(Callback callback) {

        List<Category> categories = categoryRepository.getAllCategories();
        if(categories != null){
            callback.onSuccess(categories);
        }else{
            callback.onError(new GetAllCategoriesException("Deu ruim"));
        }

    }
}
