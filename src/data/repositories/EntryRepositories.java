package data.repositories;

import data.models.Entry;

import java.util.List;

public interface EntryRepositories {

    Entry save(Entry entry);

    List<Entry> findAll();
    Entry findById(int id);
    Entry findByEntryIdAndDiaryId(int entryId, int diaryId);
    void delete(int id);
    void delete(Entry entry);
    long count();
    void clear();

    int getId();
}
