package custom_exeptions;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(String exception) {
        super(exception);
    }
}
