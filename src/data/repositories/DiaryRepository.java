package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface DiaryRepository {
    Diary save(Diary entry);
    List<Diary> findAll();
    Diary findById(int id);
    Diary findByEntryIdAndDiaryId(int entryId, int diaryId);

    Diary findByDiaryIdAndDiaryId(int diaryId, int entryId);

    void delete(int id);
    void delete(Diary entry);
    long count();
    void clear();

    int getId();
}
