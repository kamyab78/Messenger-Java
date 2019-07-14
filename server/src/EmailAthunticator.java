import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAthunticator extends Authenticator {
    String user;
    String pw;
    public EmailAthunticator (String username, String password)
    {
        super();
        this.user = username;
        this.pw = password;
    }
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(user, pw);
    }

}
