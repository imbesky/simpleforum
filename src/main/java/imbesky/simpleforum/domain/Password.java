package imbesky.simpleforum.domain;

import imbesky.simpleforum.exception.PasswordException;
import jakarta.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class Password {
    private static final String PASSWORD_FORMAT = "^[a-zA-Z0-9]{4}$";
    private String password;
    public Password() {
    }

    public Password(final String string){
        validate(string);
        password = string;
    }

    public boolean check(final String input){
        return password.equals(input);
    }

    private void validate(final String input){
        if(Pattern.matches(PASSWORD_FORMAT,input)){
            return;
        }
        throw new PasswordException();
    }
}
