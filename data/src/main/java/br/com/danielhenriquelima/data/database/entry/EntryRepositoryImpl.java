package br.com.danielhenriquelima.data.database.entry;

import android.content.Context;

import java.util.List;

import br.com.danielhenriquelima.data.database.AppDatabase;
import br.com.danielhenriquelima.data.model.EntryModel;
import br.com.danielhenriquelima.domain.exception.AddNewEntryException;
import br.com.danielhenriquelima.domain.entity.Entry;
import br.com.danielhenriquelima.repository.EntryRepository;

public class EntryRepositoryImpl implements EntryRepository {

    private AppDatabase mDb;

    public EntryRepositoryImpl(Context context){
        mDb = AppDatabase.getInstance(context);
    }


    @Override
    public void createNewEntry(final Entry tEntry) throws AddNewEntryException {
    }

    @Override
    public List<Entry> getAllEntries() {
        return null;
    }

    @Override
    public Entry getEntryById(final int id) {
        return null;
    }

    private Entry entryModelToEntry(EntryModel entryModel) {
        return new Entry(entryModel.getId(), entryModel.getName(),
                entryModel.getValue(), entryModel.getDate(), entryModel.getDueDate(), entryModel.getCategoryModelId(), entryModel.isCredit());
    }

    @Override
    public boolean deleteEntry(int id) {
        return false;
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return null;
    }
}
