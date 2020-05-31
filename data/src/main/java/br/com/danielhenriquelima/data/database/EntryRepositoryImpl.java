package br.com.danielhenriquelima.data.database;

import android.content.Context;

import java.util.List;

import br.com.danielhenriquelima.data.executor.AppExecutors;
import br.com.danielhenriquelima.data.model.EntryModel;
import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.domain.model.Entry;
import br.com.danielhenriquelima.repository.EntryRepository;

public class EntryRepositoryImpl implements EntryRepository {

    private AppDatabase mDb;
    private Entry entry = null;

    public EntryRepositoryImpl(Context context){
        mDb = AppDatabase.getInstance(context);
    }


    @Override
    public int createNewEntry(Entry entry) {

        final EntryModel entryModel = new EntryModel(entry);

        try{
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.entryDao().insertEntry(entryModel);
                }
            });
        }catch (Exception e){
            return -1;
        }

        return 0;
    }

    @Override
    public List<Entry> getAllEntries() {
        return null;
    }

    @Override
    public Entry getEntryById(final int id) {
        try{

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    EntryModel entryModel = mDb.entryDao().getEntryById(id);
                    final Entry tEntry = new Entry(entryModel.getId(), entryModel.getName(),
                            entryModel.getValue(), entryModel.getDate(), entryModel.getDueDate(),
                            new Category(entryModel.getCategoryModel().getIdCat(), entryModel.getCategoryModel().getName()),
                            entryModel.isCredit());

                    entry = tEntry;
                }
            });
        }catch (Exception e){
            return null;
        }
        return entry;
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
