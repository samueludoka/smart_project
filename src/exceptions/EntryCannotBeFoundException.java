package exceptions;

public class EntryCannotBeFoundException extends RuntimeException{
    public EntryCannotBeFoundException(String message){
        super(message);
    }
}
