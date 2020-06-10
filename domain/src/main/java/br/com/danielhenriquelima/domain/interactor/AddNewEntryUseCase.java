package br.com.danielhenriquelima.domain.interactor;

import android.util.Log;

import br.com.danielhenriquelima.domain.exception.AddNewEntryException;
import br.com.danielhenriquelima.domain.pojo.Entry;
import br.com.danielhenriquelima.repository.EntryRepository;

public final class AddNewEntryUseCase implements UseCaseIn<Entry> {

    private EntryRepository entryRepository;

    public AddNewEntryUseCase(EntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }

    @Override
    public void execute(Entry entry, Callback callback){

        try{
            entryRepository.createNewEntry(entry);
        }catch (AddNewEntryException e){
            Log.d("DABUEK", e.getLocalizedMessage());
        }

        if(entry != null)
            callback.onSuccess();
        else
            callback.onError(new AddNewEntryException("Error while inserting new Entry on database"));
    }
}