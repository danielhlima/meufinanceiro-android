package br.com.danielhenriquelima.repository;

import java.util.List;

import br.com.danielhenriquelima.domain.model.Entry;

public interface EntryRepository {

    int createNewEntry(Entry entry);
    List<Entry> getAllEntries();
    Entry getEntryById(int id);
    boolean deleteEntry(int id);
    Entry updateEntry(Entry entry);
}
