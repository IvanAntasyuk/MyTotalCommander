package common_msg;

public class AuthMessage extends AbstractMessage {

    public String login;
    public String password;
    public String message;

    public AuthMessage() {
    }

    public AuthMessage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthMessage(String message) { this.message = message;
    }
}
