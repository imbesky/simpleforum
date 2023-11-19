package imbesky.simpleforum.exception;

import static imbesky.simpleforum.constant.ExceptionMessage.PASSWORD_EXCEPTION_MESSAGE;

public class PasswordException extends IllegalArgumentException{
    public PasswordException(){
        super(PASSWORD_EXCEPTION_MESSAGE);
    }
}
