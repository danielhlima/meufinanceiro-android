package br.com.danielhenriquelima.domain.interactor;

import br.com.danielhenriquelima.domain.exception.AddNewEntryException;
import br.com.danielhenriquelima.domain.model.Entry;
import br.com.danielhenriquelima.repository.EntryRepository;

public final class AddNewEntryUseCase implements UseCase<Entry> {

    private EntryRepository entryRepository;

    public AddNewEntryUseCase(EntryRepository entryRepository){
        this.entryRepository = entryRepository;
    }

    @Override
    public void execute(final Entry enty, Callback callback){

        if(entryRepository.createNewEntry(enty) != -1)
            callback.onSuccess();
        else
            callback.onError(new AddNewEntryException("Error while inserting new Entry on database"));
    }
}
