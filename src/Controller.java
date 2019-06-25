import com.sun.glass.ui.CommonDialogs;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

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
    @FXML Button btnsubmit;
    @FXML Text txts;
    @FXML Button btnphoto;
    List<String> strings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnphoto.setOnAction(event -> {
            FileChooser fc = new FileChooser();
//fc.getExtensionFilters().add(new CommonDialogs.ExtensionFilter("*jpg"));
//     String photo = fc.
            File selectedFile = fc.showOpenDialog(null);
            if (selectedFile != null) {
                String photo = selectedFile.getPath();
                aks.add(photo);
            }

        });
        btnsubmit.setOnAction(event -> {
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
            txts.setText("your submit is ok;Lets Go");
            try {
                client.dataOutputStream.writeUTF(etelagir.get(0));
                client.dataOutputStream.writeUTF(etelagir.get(1));
                client.dataOutputStream.writeUTF(etelagir.get(2));
                client.dataOutputStream.writeUTF(etelagir.get(3));
                client.dataOutputStream.writeUTF(etelagir.get(4));
                client.dataOutputStream.writeUTF(aks.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnGoTo.setOnAction(event -> {
            try {

                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("GoTo.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            client.stage.show();
        });
    }
//
//    public void chooseImage(MouseEvent mouseEvent) {
//        FileChooser chooser =
//    }
}
