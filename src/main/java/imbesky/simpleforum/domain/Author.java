package imbesky.simpleforum.domain;

import static imbesky.simpleforum.constant.Format.BLANK;
import static imbesky.simpleforum.constant.Format.EMPTY;

import imbesky.simpleforum.exception.AuthorException;

public class Author {
    private final String author;
    private final static int MIN_LENGTH = 4;
    private final static int MAX_LENGTH = 12;
    public Author(String string){
        String input = string.replace(BLANK, EMPTY);
        validate(input);
        author = input;
    }
    public String authorName(){
        return author;
    }
    private void validate(String input){
        if(input.length()<MIN_LENGTH||input.length()>MAX_LENGTH){
            throw new AuthorException();
        }
    }
}
