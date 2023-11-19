package imbesky.simpleforum.domain;

import imbesky.simpleforum.exception.PasswordException;

public class Password {
    private static final int PROPER_LENGTH = 4;
    private final String password;
    public Password(final String string){
        validate(string);
        password = string;
    }

    public String getPassword() {
        return password;
    }

    private void validate(final String input){
        if(input.length()!=PROPER_LENGTH){
            throw new PasswordException();
        }
    }
}
