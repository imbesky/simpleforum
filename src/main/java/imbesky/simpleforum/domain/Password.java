package imbesky.simpleforum.domain;

import static imbesky.simpleforum.constant.Format.PASSWORD_FORMAT;

import imbesky.simpleforum.exception.PasswordException;
import java.util.regex.Pattern;

public class Password {
    private final String password;
    public Password(final String string){
        validate(string);
        password = string;
    }

    public boolean checkPassword(final String input){
        return password.equals(input);
    }

    private void validate(final String input){
        if(Pattern.matches(PASSWORD_FORMAT,input)){
            return;
        }
        throw new PasswordException();
    }
}
