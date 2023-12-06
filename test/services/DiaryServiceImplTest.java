package services;

import exceptions.UserExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplTest {
    DiaryServiceImpl diaryService;

    @BeforeEach
    public void startEveryTestWith(){
        diaryService = new DiaryServiceImpl();

    }
    @Test
    public void registerUser_registerUserAgain_throwExceptionTest(){
        diaryService.register("philip","password");
        assertThrows(UserExistException.class,() -> diaryService.register("philip", "password"));
    }


}