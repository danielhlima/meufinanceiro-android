package br.com.danielhenriquelima.meufinanceiro.presenter.entry;

import android.content.Context;
import android.util.Log;

import br.com.danielhenriquelima.data.database.entry.EntryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.AddNewEntryUseCase;
import br.com.danielhenriquelima.domain.boundary.BoundaryIn;
import br.com.danielhenriquelima.domain.entity.Entry;

public class AddNewEntryPresenter implements BoundaryIn.Callback {

    private AddNewEntryUseCase addNewEntryUseCase;
    private EntryRepositoryImpl entryRepository;

    public AddNewEntryPresenter(Context context) {
        entryRepository = new EntryRepositoryImpl(context);
        addNewEntryUseCase = new AddNewEntryUseCase(entryRepository);
    }

    public void addNewEntry(Entry entry){
        addNewEntryUseCase.execute(entry, this);
    }

    public void getEntryById(int id){
        
    }

    @Override
    public void onSuccess() {
        Log.d("DABUEK", "Sucesso criando Entry");
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e("DABUEK", "Erro criando Entry");
    }
}
