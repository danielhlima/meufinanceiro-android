package br.com.danielhenriquelima.meufinanceiro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.databinding.ActivityMainBinding;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.usecase.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.entry.usecase.AddNewEntryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.usecase.GetAllCategoriesPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.viewmodel.CategoryViewModel;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private AddNewEntryPresenter addNewEntryPresenter;
    private AddNewCategoryPresenter addNewCategoryUsePresenter;
    private GetAllCategoriesPresenter getAllCategoriesPresenter;
    private List<Category>categoriesList = new ArrayList<Category>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setSupportActionBar(mBinding.toolbar);

//        //TODO: Use Tata's recomendation
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                addNewCategoryUsePresenter = new AddNewCategoryPresenter(getApplicationContext());
//                addNewCategoryUsePresenter.addNewCategory(new Category("Mecânico"));
//            }
//        });

//        addNewEntryPresenter = new AddNewEntryPresenter(getApplicationContext());
        setupViewModel();
    }

    private void setupViewModel(){
//        final CategoryViewModel categoryViewModel = ViewModelProvider.AndroidViewModelFactory.
//                getInstance(getApplication()).create(CategoryViewModel.class);
//
//        getAllCategoriesPresenter = new GetAllCategoriesPresenter(getApplicationContext(), categoryViewModel);
//
//        //TODO: Use Tata's recomendation
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                getAllCategoriesPresenter.getAllCategories();
//            }
//        });
//
//        //TODO: categories ready to use
//        categoryViewModel.getCategories().observe(this, new Observer<List<Category>>() {
//            @Override
//            public void onChanged(List<Category> categories) {
//                categoriesList = categories;
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_new_category:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_add_new_entry:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
