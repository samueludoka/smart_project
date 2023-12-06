package data.repositories;

import data.models.Entry;
import exceptions.EntryCannotBeFoundException;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepositories {
    private List <Entry> entries = new ArrayList<>();
    private int count;

    @Override
    public Entry save(Entry entry) {
        if(isNew(entry)) {
            count++;
            entry.setId(generateNewId());
            entries.add(entry);
            return entry;
        }
        else update(entry);
        return entry;
    }

    private void update(Entry updatedEntry) {
        Entry oldEntry = findById(updatedEntry.getId());
        entries.remove(oldEntry);
        entries.add(updatedEntry);
    }
    private boolean isNew(Entry entry) {
        return entry.getId() == 0;
    }

    private int generateNewId(){
        return  count;
    }

    @Override
    public List<Entry> findAll(){
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry: entries){
            if(entry.getId() == id){
                return entry;
            }
        }
        throw new EntryCannotBeFoundException("Entry Not Found");
    }
    @Override
    public Entry findByEntryIdAndDiaryId(int entryId, int diaryId) {
        return null;
    }
    @Override
    public void delete(int id) {
        Entry entry = findById(id);
        entries.remove(entry);
        count--;

    }
    @Override
    public void delete(Entry entry) {
        Entry entryToDelete = findById(entry.getId());
        entries.remove(entryToDelete);
        count--;

    }
    @Override
    public long count() {
        return count ;
    }



    @Override
    public void clear() {
        entries.clear();
        count--;
        count--;
        count--;


    }

    /**
     * @return
     */
    @Override
    public int getId() {
        return 0;
    }
}
