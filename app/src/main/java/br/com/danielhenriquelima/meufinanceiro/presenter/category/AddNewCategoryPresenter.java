package br.com.danielhenriquelima.meufinanceiro.presenter.category;

import android.content.Context;
import android.os.Handler;

import br.com.danielhenriquelima.data.database.category.CategoryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.AddNewCategoryUseCase;
import br.com.danielhenriquelima.domain.boundary.BoundaryIn;
import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.view.CategoryView;

public class AddNewCategoryPresenter implements BoundaryIn.Callback {

    private AddNewCategoryUseCase addNewCategoryUseCase;
    private CategoryRepositoryImpl categoryRepository;
    private CategoryView createCategoryView;
    private Context context;

    public AddNewCategoryPresenter(Context context, CategoryView createCategoryView) {
        categoryRepository = new CategoryRepositoryImpl(context);
        addNewCategoryUseCase = new AddNewCategoryUseCase(categoryRepository);
        this.createCategoryView = createCategoryView;
        this.context = context;
    }

    public void addNewCategory(Category category){
        addNewCategoryUseCase.execute(category, this);
    }


    @Override
    public void onSuccess() {
        Handler handler = new Handler(context.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                createCategoryView.onSuccess();
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onError(final Throwable throwable) {
        Handler handler = new Handler(context.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                createCategoryView.onError(throwable);
            }
        };
        handler.post(runnable);
    }
}
