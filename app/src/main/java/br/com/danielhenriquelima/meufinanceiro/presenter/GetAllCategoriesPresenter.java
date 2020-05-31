package br.com.danielhenriquelima.meufinanceiro.presenter;

import android.content.Context;

import java.util.List;

import br.com.danielhenriquelima.data.database.CategoryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.GetAllCategoriesUseCase;
import br.com.danielhenriquelima.domain.interactor.UseCaseOut;
import br.com.danielhenriquelima.domain.model.Category;

public class GetAllCategoriesPresenter implements UseCaseOut.Callback<List<Category>> {

    private GetAllCategoriesUseCase getAllCategoriesUseCase;
    private CategoryRepositoryImpl categoryRepository;

    public GetAllCategoriesPresenter(Context context){
        categoryRepository = new CategoryRepositoryImpl(context);
        getAllCategoriesUseCase = new GetAllCategoriesUseCase(categoryRepository);
    }

    public void getAllCategories(){
        getAllCategoriesUseCase.execute(this);
    }

    @Override
    public void onSuccess(List<Category> parameter) {

        int b = 0;
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
