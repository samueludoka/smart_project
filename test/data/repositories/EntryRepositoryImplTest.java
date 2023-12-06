package data.repositories;

import data.models.Entry;
import exceptions.EntryCannotBeFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryImplTest {
    private EntryRepositories entryRepositories;

    @BeforeEach
    public void startAllTestWith(){
        entryRepositories = new EntryRepositoryImpl();
    }
    @Test
    public void saveOneEntry_CountIsOneTest(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        assertEquals(1, entryRepositories.count());
    }
    @Test
    public void saveTwoEntry_CountIstwoTest(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        Entry entry1 = new Entry();
        entryRepositories.save(entry1);
        assertEquals(2, entryRepositories.findAll().size());
    }
    @Test
    public void saveTwoEntry_findAllCountReturnsTwoTest(){
        Entry entry = new Entry();
        Entry secondEntry = new Entry();
        entryRepositories.save(entry);
        entryRepositories.save(secondEntry);
        assertEquals(2, entryRepositories.findAll().size());
    }
    @Test
    public void saveUpdateEntryDoesNotInfleunceCountTest(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        Entry updateEntry = new Entry();
        updateEntry.setId(1);
        entryRepositories.save(updateEntry);
        assertEquals(1,entryRepositories.count());
        assertEquals(updateEntry, entryRepositories.findById(1));

    }
    @Test
    public void saveAnEntryAndDeleteTheEntryCheckCountTest(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        entryRepositories.delete(entry);
        assertEquals(0,entryRepositories.count());

    }
    @Test
    public void saveEntryDeleteEntryByEntryFindEntryThrowExceptionTest(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        entryRepositories.delete(entry);
        assertThrows(EntryCannotBeFoundException.class, ()-> entryRepositories.findById(entry.getId()));

    }
    @Test
    public void saveEntryDeleteEntryById(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        entryRepositories.delete(1);
        assertEquals(0,entryRepositories.count());

    }
    @Test
    public void saveEntryAndFindById(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        entryRepositories.delete(entry);
        Entry secondEntry = new Entry();
        entryRepositories.save(secondEntry);
        entryRepositories.findById(1);
        assertEquals(1,entryRepositories.findAll().size());
    }
    @Test
    public void saveMoreThanEntryAndClearAll(){
        Entry entry = new Entry();
        entryRepositories.save(entry);
        Entry secondEntry = new Entry();
        entryRepositories.save(secondEntry);
        Entry thirdEntry = new Entry();
        entryRepositories.save(thirdEntry);
        entryRepositories.clear();
        assertEquals(0,entryRepositories.count());

    }
}