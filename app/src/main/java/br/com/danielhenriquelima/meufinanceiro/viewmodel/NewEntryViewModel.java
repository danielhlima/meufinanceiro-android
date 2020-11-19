package br.com.danielhenriquelima.meufinanceiro.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import br.com.danielhenriquelima.domain.entity.Entry;
import br.com.danielhenriquelima.meufinanceiro.presenter.entry.AddNewEntryPresenter;
import br.com.danielhenriquelima.meufinanceiro.view.EntryView;
import br.com.danielhenriquelima.meufinanceiro.view.fragment.BaseFragment;

public class NewEntryViewModel extends AndroidViewModel implements EntryView {

    private BaseFragment baseFragment;
    private AddNewEntryPresenter addNewEntryPresenter;

    public NewEntryViewModel(@NonNull Application application) {
        super(application);
        addNewEntryPresenter = new AddNewEntryPresenter(application.getBaseContext(), this);
    }

    @Override
    public void createEntry(Entry entry) {
        addNewEntryPresenter.addNewEntry(entry);
    }

    @Override
    public void onSuccess() {
        baseFragment.onSuccess();
    }

    @Override
    public void onError(Throwable throwable) {
        baseFragment.onError(throwable);
    }
}
