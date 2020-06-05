package br.com.danielhenriquelima.meufinanceiro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.usecases.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.entry.AddNewEntryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.usecases.GetAllCategoriesPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.viewmodel.CategoryViewModel;


public class MainActivity extends AppCompatActivity {

    private AddNewEntryPresenter addNewEntryPresenter;
    private AddNewCategoryPresenter addNewCategoryUsePresenter;
    private GetAllCategoriesPresenter getAllCategoriesPresenter;
    private List<Category>categoriesList = new ArrayList<Category>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Use Tata's recomendation
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                addNewCategoryUsePresenter = new AddNewCategoryPresenter(getApplicationContext());
                addNewCategoryUsePresenter.addNewCategory(new Category("Mecânico"));
            }
        });

        addNewEntryPresenter = new AddNewEntryPresenter(getApplicationContext());
        setupViewModel();
    }

    private void setupViewModel(){
        final CategoryViewModel categoryViewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(CategoryViewModel.class);

        getAllCategoriesPresenter = new GetAllCategoriesPresenter(getApplicationContext(), categoryViewModel);

        //TODO: Use Tata's recomendation
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                getAllCategoriesPresenter.getAllCategories();
            }
        });

        //TODO: categories ready to use
        categoryViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoriesList = categories;
            }
        });
    }
}
