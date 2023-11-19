package imbesky.simpleforum.domain;

import static imbesky.simpleforum.constant.Format.DOTS;

import imbesky.simpleforum.exception.ContentException;

public class Content {
    private static final int FIRST_INDEX = 0;
    private static final int SHORT_END_INDEX = 99;
    private static final int MAX_LENGTH = 1_000;
    private final String content;
    public Content(String string){
        validate(string);
        content = string;
    }
    public String shortContent(){
        if (content.length()<SHORT_END_INDEX){
            return content;
        }
        return content.substring(FIRST_INDEX,SHORT_END_INDEX).concat(DOTS);
    }
    public String fullContent(){
        return content;
    }
    private void validate(final String input){
        if(input.isBlank() ||input.length()>MAX_LENGTH){
            throw new ContentException();
        }
    }
}