package imbesky.simpleforum.exception;

import static imbesky.simpleforum.constant.ExceptionMessage.TITLE_EXCEPTION_MESSAGE;

public class TitleException extends IllegalArgumentException{
    public TitleException(){
        super(TITLE_EXCEPTION_MESSAGE);
    }
}
