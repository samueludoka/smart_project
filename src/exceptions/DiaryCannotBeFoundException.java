package exceptions;

public class DiaryCannotBeFoundException extends RuntimeException{
    public DiaryCannotBeFoundException(String message){
        super (message);
    }
}
