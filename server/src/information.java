import com.sun.org.omg.CORBA.Initializer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class information implements Initializable {
    @FXML
    TextField txtfname;
    @FXML TextField txtffamilyname;
    @FXML
    Button txtback;
    @FXML TextField txtfemail;
    @FXML TextField txtusername;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
txtfname.setText(server.etelaat.get(0));
txtffamilyname.setText(server.etelaat.get(1));
txtfemail.setText(server.etelaat.get(2));
txtusername.setText(server.etelaat.get(3));
txtback.setOnAction(event -> {

    try {
        server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Go.fxml"))));
    } catch (IOException e) {
        e.printStackTrace();
    }
});
    }
}
