import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
public class Email implements Initializable {
    public static int zakhireyecode;
    private int code;
    private int port = 465;
    private String host = "smtp.gmail.com";
    private String from = "ghassemikamyab@gmail.com";
    private String username = "ghassemikamyab@gmail.com";
    private String password = "Kamyab1378";
    private Portocol portocol = Portocol.SMTPS;


    //private String cod;
    public int getCode() {
        return code;
    }

    public enum Portocol {
        SMTP, SMTPS, TLS
    }

    public void sendMail(String to, String subject, String body) {
//        Create a Properties object to contain settings for the SMTP protocol provider.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        switch (portocol) {
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
        }
//        If SMTP authentication is required you must set the mail.smtp.auth property and construct a Authenticator instance that returns a PasswordAuthentication instance with your username and password.
        Authenticator authenticator = null;
        props.put("mail.smtp.auth", true);
        authenticator = new Authenticator() {
            private PasswordAuthentication pa = new PasswordAuthentication(username, password);

            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return pa;
            }
        };
//        Create a Session instance using the Properties object and the Authenticator object. If SMTP authentication in not needed a null value can be supplied for the Authenticator.
        Session session = Session.getInstance(props, authenticator);
        session.setDebug(true);// The session.setDebug(boolean) method can be used to print out the current session's activity.
//        Construct a MimeMessage instance, populate the message headers and content and then send the message.
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

    }

    public String createCode() {
        code = new Random().nextInt(99999 - 10000 + 1) + 10000;
        String cod = String.valueOf(code);
        zakhireyecode = code;
        return cod;
    }

    @FXML
    Button btntest;
    @FXML
    TextField txtfsubmit;
    @FXML
    Text txt;
    @FXML
    Button btngo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String c = createCode();
        sendMail(Controller.etelagir.get(2), "your code", c);
        btntest.setOnAction(event -> {
            if (c.equals(txtfsubmit.getText())) {
                txt.setText("ok");
                btngo.setOnAction(event1 -> {
                    try {
                        server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("start.fxml"))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else
                txt.setText("code is not valid");
        });
    }
}
