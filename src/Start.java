import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Start implements Initializable {
    public static String username;
    @FXML
    Text txt;
    @FXML
    Button btngo;
    @FXML
    Button btnnew;
    @FXML
    TextField txtfusername;
    @FXML
    Button btnstart;
    @FXML
    TextField txtfpass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnstart.setOnAction(event -> {
            username = txtfusername.getText();
            String pass = txtfpass.getText();
//            txt.setText(username);
            try {
                add add = new add();
                ArrayList<String> start = new ArrayList<>();
                start = add.getPerson(username);
                if (start.isEmpty()) {
                    txt.setText("this user name not exsist");
                }
                if (!add.getPerson(username).get(5).equals(pass)) {
                    txt.setText("your pass is not valid");
                }
                if (add.getPerson(username).get(5).equals(pass)) {
                    txt.setText("welcome");
                    btngo.setOnAction(event1 -> {
                        try {
                            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("search.fxml"))));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnnew.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("controll.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
