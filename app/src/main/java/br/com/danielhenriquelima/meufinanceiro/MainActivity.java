package br.com.danielhenriquelima.meufinanceiro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import java.util.Date;

import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.domain.model.Entry;
import br.com.danielhenriquelima.meufinanceiro.presenter.AddNewEntryPresenter;

public class MainActivity extends AppCompatActivity {

    private AddNewEntryPresenter addNewEntryPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewEntryPresenter = new AddNewEntryPresenter(getApplicationContext());
        Entry entry = new Entry("Nome Entry", 10.0f, new Date(), new Category("Comida"), false);
        addNewEntryPresenter.addNewEntry(entry);

    }
}
