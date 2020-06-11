package br.com.danielhenriquelima.meufinanceiro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.presenter.ui.HomeFragment;
import br.com.danielhenriquelima.meufinanceiro.presenter.ui.HomeFragmentDirections;
import br.com.danielhenriquelima.meufinanceiro.presenter.ui.NewCategoryFragmentDirections;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.category.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.entry.AddNewEntryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.category.GetAllCategoriesPresenter;


public class MainActivity extends AppCompatActivity {


    private AddNewEntryPresenter addNewEntryPresenter;
    private AddNewCategoryPresenter addNewCategoryUsePresenter;
    private GetAllCategoriesPresenter getAllCategoriesPresenter;
    private List<Category>categoriesList = new ArrayList<Category>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //TODO: Use Tata's recomendation
//        AppExecutors.getInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                addNewCategoryUsePresenter = new AddNewCategoryPresenter(getApplicationContext());
//                addNewCategoryUsePresenter.addNewCategory(new Category("Mecânico"));
//            }
//        });

//        addNewEntryPresenter = new AddNewEntryPresenter(getApplicationContext());
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
//                Navigation.findNavController(this, R.id.nav_host).navigate(R.id.dest_new_category);

//                NavDirections action = HomeFragmentDirections.actionDestNewCategory();
//                Navigation.findNavController(this, R.id.nav_host).navigate(action);

                HomeFragmentDirections.ActionDestNewCategory action = HomeFragmentDirections.actionDestNewCategory();
                action.setParam1("Nova");
                action.setParam2("Categoria");
                Navigation.findNavController(this, R.id.nav_host).navigate(action);

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
