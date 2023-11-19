package imbesky.simpleforum.exception;

import static imbesky.simpleforum.constant.ExceptionMessage.AUTHOR_EXCEPTION_MESSAGE;

public class AuthorException extends IllegalArgumentException{
    public AuthorException(){
        super(AUTHOR_EXCEPTION_MESSAGE);
    }
}