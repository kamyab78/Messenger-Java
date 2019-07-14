import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Change implements Initializable {
    public static ArrayList<String> etelagir = new ArrayList<>();
    public static ArrayList<String> aks = new ArrayList<>();
    @FXML
    TextField txtfname;
    @FXML TextField txtffamily;
    @FXML TextField txtfemail;
    @FXML TextField txtfuser;
    @FXML TextField txtfpass;
    @FXML
    Button btnphoto;
    @FXML Button btnback;
    @FXML
    Text txt;
    @FXML Button btnok;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
btnback.setOnAction(event -> {
    try {
        server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
    } catch (IOException e) {
        e.printStackTrace();
    }
});
btnphoto.setOnAction(event -> {
    FileChooser fc = new FileChooser();
    File selectedFile = fc.showOpenDialog(null);
    if (selectedFile != null) {
        String photo = selectedFile.getPath();
        aks.add(photo);
    }
});
btnok.setOnAction(event -> {
        String name;
        name = txtfname.getText();

//    System.out.println();
        etelagir.add(name);
        String familyname;
        familyname = txtffamily.getText();
        etelagir.add(familyname);
        String email;
        email = txtfemail.getText();
        etelagir.add(email);
        String username;
        username = txtfuser.getText();
        etelagir.add(username);
        String pass;
        pass = txtfpass.getText();
        etelagir.add(pass);
        String Photo;
        Photo = null;
    try {
        add add = new add();
        add.editePerson(Start.username , name , familyname , email , username , pass , aks.get(0));
    } catch (Exception e) {
        e.printStackTrace();
    }
        txt.setText("ok");
//        etela etela = new etela(name , familyname , email , username , pass , aks.get(0));

});
    }
}
