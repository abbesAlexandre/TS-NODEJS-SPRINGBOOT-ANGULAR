package ovh.alexandreabbes.ListeDeCourse.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}