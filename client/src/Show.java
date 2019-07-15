import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Show implements Initializable {
    @FXML
    TextArea history;
    @FXML
    Button btnshow;
    @FXML Button btnback;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnback.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("GoTo.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnshow.setOnAction(event -> {
            try {
                Addpayam ap = new Addpayam();

                history.appendText(Start.username+":");
                for (int i = 0; i <ap.getpm(Start.username,Search.username).size() ; i++) {
                    history.appendText(ap.getpm(Start.username,Search.username).get(i)+"\n"+ap.gettarikh(Start.username,Search.username).get(i)+"\n");
                }
                history.appendText( Search.username+":");
                for (int i = 0; i <ap.getpm(Search.username,Start.username).size() ; i++) {
                    history.appendText(ap.getpm(Search.username,Start.username).get(i)+"\n"+ap.gettarikh(Search.username,Start.username).get(i)+"\n");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
