package RentApp.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(){
        super("this password is invalid!");
    }
}
