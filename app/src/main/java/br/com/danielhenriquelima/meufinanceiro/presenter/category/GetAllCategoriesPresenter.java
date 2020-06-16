package br.com.danielhenriquelima.meufinanceiro.presenter.category;

import android.content.Context;

import java.util.List;

import br.com.danielhenriquelima.data.database.category.CategoryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.GetAllCategoriesUseCase;
import br.com.danielhenriquelima.domain.boundary.BoundaryOut;
import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.view.CategoryView;

public class GetAllCategoriesPresenter implements BoundaryOut.Callback<List<Category>> {

    private GetAllCategoriesUseCase getAllCategoriesUseCase;
    private CategoryRepositoryImpl categoryRepository;
    private CategoryView categoryView;


    public GetAllCategoriesPresenter(Context context, CategoryView categoryView){
        categoryRepository = new CategoryRepositoryImpl(context);
        getAllCategoriesUseCase = new GetAllCategoriesUseCase(categoryRepository);
        this.categoryView = categoryView;
    }

    public void getAllCategories(){
        getAllCategoriesUseCase.execute(this);
    }

    @Override
    public void onSuccess(List<Category> parameter) {
        categoryView.receiveCategories(parameter);
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
