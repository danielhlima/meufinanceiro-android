package br.com.danielhenriquelima.meufinanceiro.presenter.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.meufinanceiro.presenter.view.CategoryView;

public class CategoryViewModel extends AndroidViewModel implements CategoryView {

    private MutableLiveData<List<Category>>categories = new MutableLiveData<List<Category>>();

    public CategoryViewModel(Application application){
        super(application);
    }

    @Override
    public void showCategories(List<Category> categories) {
        this.categories.postValue(categories);
    }

    public MutableLiveData<List<Category>> getCategories(){
        return categories;
    }
}
