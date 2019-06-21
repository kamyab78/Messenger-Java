import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static ArrayList<String>etelaat = new ArrayList<>();
    @FXML
    TextField txtfUserName;
    @FXML
    TextField txtfName;
    @FXML
    TextField txtfEmail;
    @FXML
    TextField txtfFamilyname;
    @FXML
    TextField txtfPass;
    @FXML
    Button btnGoTo;
    @FXML TextField txtfphoto;
//    public List<String> strings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnGoTo.setOnAction(event -> {
            String name;
            name = txtfName.getText();
            etelaat.add(name);
            String familyname;
            familyname = txtfFamilyname.getText();
            etelaat.add(familyname);
            String email;
            email = txtfEmail.getText();
            etelaat.add(email);
            String username;
            username = txtfEmail.getText();
            etelaat.add(username);
            String pass;
            pass = txtfPass.getText();
            etelaat.add(pass);
            String photo;
            photo = txtfphoto.getText();
            etelaat.add(photo);
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("GoTo.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            client.stage.show();
        });
    }
}
