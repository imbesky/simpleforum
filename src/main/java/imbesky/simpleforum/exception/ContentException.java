package imbesky.simpleforum.exception;

import static imbesky.simpleforum.constant.ExceptionMessage.CONTENT_EXCEPTION_MESSAGE;

public class ContentException extends IllegalArgumentException{
    public ContentException(){
        super(CONTENT_EXCEPTION_MESSAGE);
    }
}
