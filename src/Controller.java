import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static ArrayList<String> etelagir = new ArrayList<>();
    public static ArrayList<String> aks = new ArrayList<>();
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
    @FXML
    TextField txtfphoto;
    @FXML
    Text txt;
    @FXML
    Button btntest;
    List<String> strings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btntest.setOnAction(event -> {
            String photo;
            photo = txtfphoto.getText();
            aks.add(photo);
            File file = new File(photo);
            if (!(file.exists())) {
                txt.setText("File not exists");
            } else
                txt.setText("ok");
        });
        btnGoTo.setOnAction(event -> {
            try {
                String name;
                name = txtfName.getText();
                etelagir.add(name);
                String familyname;
                familyname = txtfFamilyname.getText();
                etelagir.add(familyname);
                String email;
                email = txtfEmail.getText();
                etelagir.add(email);
                String username;
                username = txtfUserName.getText();
                etelagir.add(username);
                String pass;
                pass = txtfPass.getText();
                etelagir.add(pass);

                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("search.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.stage.show();
        });
    }
}
