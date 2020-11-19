package br.com.danielhenriquelima.meufinanceiro.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.NavGraphDirections;
import br.com.danielhenriquelima.meufinanceiro.R;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.entry.AddNewEntryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.GetAllCategoriesPresenter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Navigation.findNavController(this, R.id.nav_host).navigate(NavGraphDirections.actionGlobalDestNewCategory());
                return true;

            case R.id.action_add_new_entry:
                Navigation.findNavController(this, R.id.nav_host).navigate(NavGraphDirections.actionGlobalDestCategoryList());
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
