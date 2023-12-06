package services;

import data.models.Diary;
import exceptions.UserExistException;

public class DiaryServiceImpl implements DiaryService {
    public int register;
    private Diary repository = new Diary();

    @Override
    public void register(String username, String password) {
        Diary foundDiary = repository;
        if (foundDiary != null) throw new UserExistException(username + "username exist");

        Diary newDiary = new Diary();
        newDiary.setUserName(username);
        newDiary.setPassword(password);

        repository.save(newDiary);
    }
}