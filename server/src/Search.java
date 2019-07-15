import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public static String getUsername() {
        return username;
    }
    String user;

    public static String username;
    public static ArrayList<String>clientinfor=new ArrayList<>();
    @FXML
    Button btnnext;
    @FXML Button btnsearch;
    @FXML
    Text txt;
    @FXML
    TextField txtfsearch;
    @FXML Button btnchat;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
//            user = server.dataInputStream.readUTF();
            add a = new add();
            ArrayList<String > ar = new ArrayList<>();
            ar=a.getPerson(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnchat.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("history.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnsearch.setOnAction(event -> {
            username = txtfsearch.getText();
            try {
                add add = new add();
                ArrayList<String> arr = new ArrayList<>();
                arr = add.getPerson(username);
                if(!arr.isEmpty()){
                    txt.setText("ok");
                    btnnext.setOnAction(event1 -> {
                        try {
                            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Go.fxml"))));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                else
                    txt.setText("this user not exists");
            } catch (Exception e) {
                e.printStackTrace();
            }


//            txt.setText("your id is :");
        });

    }
}
