import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class conection implements Initializable {
    @FXML
    javafx.scene.control.Button BtnSend;
    @FXML
    TextField txtfOutput;
    @FXML
    Button btnexit;
    public static String z;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
BtnSend.setOnAction(event -> {
String z = txtfOutput.getText();
        });
btnexit.setOnAction(event -> {
    System.exit(0);
        }
        );
    }
}
