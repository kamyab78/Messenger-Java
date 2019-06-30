import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Setting implements Initializable {
    @FXML Button btnchange;
    @FXML Button btnlogout;
    @FXML Button btnback;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       btnchange.setOnAction(event -> {
           try {
               server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("change.fxml"))));
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
       btnlogout.setOnAction(event -> {
           try {
               server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("controll.fxml"))));
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
       btnback.setOnAction(event -> {
           try {
               server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Go.fxml"))));
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
    }
}
