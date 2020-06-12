package br.com.danielhenriquelima.meufinanceiro.presenter.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.executor.AppExecutors;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.category.GetAllCategoriesPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.view.CategoryView;

public class CategoryViewModel extends AndroidViewModel implements CategoryView {

    private GetAllCategoriesPresenter getAllCategoriesPresenter;

    private MutableLiveData<List<Category>>categories = new MutableLiveData<List<Category>>();

    public CategoryViewModel(Application application){
        super(application);
        getAllCategoriesPresenter = new GetAllCategoriesPresenter(application.getBaseContext(), this);
    }

    @Override
    public void receiveCategories(List<Category> categories) {
        this.categories.postValue(categories);
    }

    public MutableLiveData<List<Category>> getCategories(){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                getAllCategoriesPresenter.getAllCategories();;
            }
        });
        return categories;
    }
}
