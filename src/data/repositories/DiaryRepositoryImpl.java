package data.repositories;

import data.models.Diary;
import exceptions.DiaryCannotBeFoundException;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List <Diary> diaries = new ArrayList<>();
    private int count;
    private Diary updatedDiary;

    @Override
    public Diary save(Diary diary) {
        if(isNew(diary)) {
            count++;
            diaries.add(diary);
            return diary;
        }
        else update(diary);
        return diary;
    }

    private boolean isNew(Diary diary) {
        return diary.getId() == 0;
    }

    private void update(Diary updatedDiary) {
        Diary oldEntry = findById(updatedDiary.getId());
        diaries.remove(oldEntry);
        diaries.add(updatedDiary);

    }
    private int generateNewId(){
        return  count;
    }


    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(int id) {
        for(Diary diary: diaries){
            if(diary.getId() == id){
                return diary;
            }
        }
        throw new DiaryCannotBeFoundException("Diary not found");
    }

    /**
     * @param entryId
     * @param diaryId
     * @return
     */
    @Override
    public Diary findByEntryIdAndDiaryId(int entryId, int diaryId) {
        return null;
    }

    @Override
    public Diary findByDiaryIdAndDiaryId(int diaryId, int entryId) {
        return null;
    }

    @Override
    public void delete(int id) {
        Diary diary = findById(id);
        diaries.remove(diary);
        count--;

    }
    @Override
    public void delete(Diary diary) {
        count --;
    }
    @Override
    public long count() {
        return count++;
    }
    @Override
    public void clear() {
        diaries.clear();
        count--;
        count--;
        count--;

    }

    @Override
    public int getId() {
        return 0;
    }
}
