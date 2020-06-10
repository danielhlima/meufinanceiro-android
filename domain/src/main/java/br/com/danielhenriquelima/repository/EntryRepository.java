package br.com.danielhenriquelima.repository;

import java.util.List;

import br.com.danielhenriquelima.domain.exception.AddNewEntryException;
import br.com.danielhenriquelima.domain.pojo.Entry;

public interface EntryRepository {

    void createNewEntry(Entry entry) throws AddNewEntryException;
    List<Entry> getAllEntries();
    Entry getEntryById(int id);
    boolean deleteEntry(int id);
    Entry updateEntry(Entry entry);
}
