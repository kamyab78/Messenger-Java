import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GoTo implements Initializable {
    public  static String bn;
    public static int x;
    Stage stage1 = new Stage();
    @FXML
    Button btnexit;
    @FXML
    TextField txtfoutput;
    @FXML
    Button btnsend;
    @FXML
    Text txtinformation;
    @FXML
    Button btninformation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
btnsend.setOnAction(event -> {
            TextArea textArea = new TextArea();
//            textArea.
//    String bn=txtfoutput.getText();
        }
        );
btnexit.setOnAction(event -> {
    System.exit(0);
});
btninformation.setOnAction(event -> {
    int x=1;
    try {
        server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("etelaat.fxml"))));
    } catch (IOException e) {
        e.printStackTrace();
    }
});
    }
}
