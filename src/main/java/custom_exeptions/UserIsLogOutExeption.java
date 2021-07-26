package custom_exeptions;

public class UserIsLogOutExeption extends RuntimeException {
    public UserIsLogOutExeption(String exception) {
        super(exception);
    }
}
