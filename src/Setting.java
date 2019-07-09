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
    @FXML Button btnpak;
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
       btnpak.setOnAction(event -> {
           try {
               add add = new add();
               add.deletePerson(Start.username);
               server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("start.fxml"))));

           } catch (Exception e) {
               e.printStackTrace();
           }
       });
    }
}
