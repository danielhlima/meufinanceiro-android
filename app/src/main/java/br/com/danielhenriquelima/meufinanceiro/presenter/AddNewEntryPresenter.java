package br.com.danielhenriquelima.meufinanceiro.presenter;

import android.content.Context;
import android.util.Log;

import br.com.danielhenriquelima.data.database.EntryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.AddNewEntryUseCase;
import br.com.danielhenriquelima.domain.interactor.UseCaseIn;
import br.com.danielhenriquelima.domain.model.Entry;

public class AddNewEntryPresenter implements UseCaseIn.Callback {

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
