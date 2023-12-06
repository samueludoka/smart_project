package data.repositories;

import data.models.Diary;
import exceptions.DiaryCannotBeFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryImplTest {
    private DiaryRepository diaryRepository;


    @BeforeEach
    public void startAllTestWith(){
        diaryRepository = new DiaryRepositoryImpl();
    }
    @Test
    public void saveOneEntry_countIsOneTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1,diaryRepository.count());
    }
    @Test
    public void saveTwoEntry_CountIsTwoTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary secondDiary = new Diary();
        diaryRepository.save(secondDiary);
        assertEquals(2,diaryRepository.findAll().size());
    }
    @Test
    public void saveTwoEntry_findAllCountReturnsTwoTest() {
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary secondDiary = new Diary();
        diaryRepository.save(secondDiary);
        assertEquals(2, diaryRepository.findAll().size());
    }
    @Test
    public void saveUpdateEntryDoesNotInfluenceCountTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary updateDiary = new Diary();
        updateDiary.setId(1);
        diaryRepository.save(updateDiary);
        assertEquals(1,diaryRepository.count());
    }
    @Test
    public void saveAnEntryAndDeleteTheEntryCheckCountTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.delete(diary);
        assertEquals(0,diaryRepository.count());
    }
    @Test
    public void saveEntryDeleteEntryByEntryFindEntryThrowExceptionTest() {
        Diary diary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.delete(diary);
        assertThrows(DiaryCannotBeFoundException.class, () -> diaryRepository.findById(diary.getId()));
    }

    @Test
    public void saveEntryDeleteEntryById() {
        Diary diary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.delete(1);
        assertEquals(0, diaryRepository.count());
    }
    @Test
    public void saveEntryAndFindById(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.delete(diary);
        Diary secondDiary = new Diary();
        diaryRepository.save(secondDiary);
        diaryRepository.findById(1);
        assertEquals(1,diaryRepository.findAll().size());
    }
    @Test
    public void saveMoreThanEntryAndClearAll(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary secondDiary = new Diary();
        diaryRepository.save(secondDiary);
        Diary thirdDiary = new Diary();
        diaryRepository.save(thirdDiary);
        diaryRepository.clear();
        assertEquals(0,diaryRepository.count());

    }
}

