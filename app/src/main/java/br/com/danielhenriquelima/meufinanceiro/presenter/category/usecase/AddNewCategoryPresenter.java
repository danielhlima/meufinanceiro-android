package br.com.danielhenriquelima.meufinanceiro.presenter.category.usecase;

import android.content.Context;
import android.util.Log;

import br.com.danielhenriquelima.data.database.category.CategoryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.AddNewCategoryUseCase;
import br.com.danielhenriquelima.domain.interactor.UseCaseIn;
import br.com.danielhenriquelima.domain.pojo.Category;

public class AddNewCategoryPresenter implements UseCaseIn.Callback {

    private AddNewCategoryUseCase addNewCategoryUseCase;
    private CategoryRepositoryImpl categoryRepository;

    public AddNewCategoryPresenter(Context context) {
        categoryRepository = new CategoryRepositoryImpl(context);
        addNewCategoryUseCase = new AddNewCategoryUseCase(categoryRepository);
    }

    public void addNewCategory(Category category){
        addNewCategoryUseCase.execute(category, this);
    }


    @Override
    public void onSuccess() {
        Log.d("DABUEK", "Sucesso criando Category");
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e("DABUEK", "Erro criando Category");
    }
}
