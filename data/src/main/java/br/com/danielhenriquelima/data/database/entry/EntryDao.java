package br.com.danielhenriquelima.data.database.entry;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import br.com.danielhenriquelima.data.model.EntryModel;

@Dao
public interface EntryDao {

    @Insert
    void insertEntry(EntryModel entryModel);

    @Query("SELECT * FROM entry WHERE id = :id")
    EntryModel getEntryById(int id);
}
