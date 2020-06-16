package br.com.danielhenriquelima.meufinanceiro.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.device.executor.AppExecutors;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.GetAllCategoriesPresenter;
import br.com.danielhenriquelima.meufinanceiro.view.CategoryView;
import br.com.danielhenriquelima.meufinanceiro.view.fragment.BaseFragment;

public class CategoryViewModel extends AndroidViewModel implements CategoryView {

    private BaseFragment baseFragment;
    private GetAllCategoriesPresenter getAllCategoriesPresenter;
    private MutableLiveData<List<Category>>categories = new MutableLiveData<List<Category>>();

    public CategoryViewModel(Application application){
        super(application);
        getAllCategoriesPresenter = new GetAllCategoriesPresenter(application.getBaseContext(), this);
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    @Override
    public void receiveCategories(List<Category> categories) {
        this.categories.postValue(categories);
    }

    @Override
    public void onSuccess() {
        if(baseFragment != null){
            baseFragment.onSuccess();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if(baseFragment != null){
            baseFragment.onError(throwable);
        }
    }

    @Override
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
