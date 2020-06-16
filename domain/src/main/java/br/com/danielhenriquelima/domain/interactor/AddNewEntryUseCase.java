package br.com.danielhenriquelima.domain.interactor;

import android.util.Log;

import br.com.danielhenriquelima.domain.boundary.BoundaryIn;
import br.com.danielhenriquelima.domain.exception.AddNewEntryException;
import br.com.danielhenriquelima.domain.entity.Entry;
import br.com.danielhenriquelima.repository.EntryRepository;

public final class AddNewEntryUseCase implements BoundaryIn<Entry> {

    private EntryRepository entryRepository;

    public AddNewEntryUseCase(EntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }

    @Override
    public void execute(Entry entry, Callback callback){
        try{
            entryRepository.createNewEntry(entry);
            callback.onSuccess();
        }catch (AddNewEntryException e){
            callback.onError(new AddNewEntryException(e.getMessage()));
        }
    }
}