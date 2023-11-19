package imbesky.simpleforum.domain;

import static imbesky.simpleforum.constant.Format.DOTS;

import imbesky.simpleforum.exception.TitleException;

public class Title {
    private static final int FIRST_INDEX = 0;
    private static final int SHORT_END_INDEX = 9;
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 50;
    private final String title;
    public Title(final String string){
        validate(string);
        title = string;
    }
    public String shortTitle(){
        if (title.length()<SHORT_END_INDEX){
            return title;
        }
        return title.substring(FIRST_INDEX,SHORT_END_INDEX).concat(DOTS);
    }
    public String fullTitle(){
        return title;
    }
    private void validate(final String input){
        if(input.length()<MIN_LENGTH||input.length()>MAX_LENGTH){
            throw new TitleException();
        }
    }
}
