package br.com.danielhenriquelima.meufinanceiro.presenter.entry;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import br.com.danielhenriquelima.data.database.entry.EntryRepositoryImpl;
import br.com.danielhenriquelima.domain.interactor.AddNewEntryUseCase;
import br.com.danielhenriquelima.domain.boundary.BoundaryIn;
import br.com.danielhenriquelima.domain.entity.Entry;
import br.com.danielhenriquelima.meufinanceiro.view.EntryView;

public class AddNewEntryPresenter implements BoundaryIn.Callback {

    private AddNewEntryUseCase addNewEntryUseCase;
    private EntryRepositoryImpl entryRepository;
    private EntryView entryView;
    private Context context;

    public AddNewEntryPresenter(Context context, EntryView entryView) {
        entryRepository = new EntryRepositoryImpl(context);
        addNewEntryUseCase = new AddNewEntryUseCase(entryRepository);
        this.entryView = entryView;
        this.context = context;
    }

    public void addNewEntry(Entry entry){
        addNewEntryUseCase.execute(entry, this);
    }

    public void getEntryById(int id){
        
    }

    @Override
    public void onSuccess() {
        Handler handler = new Handler(context.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                entryView.onSuccess();
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onError(final Throwable throwable) {
        Handler handler = new Handler(context.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                entryView.onError(throwable);
            }
        };
        handler.post(runnable);
    }
}
