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
//String
    public static ArrayList<String> information;
    public static String username;
    @FXML
    Button btnnext;
    @FXML Button btnsearch;
    @FXML
    Text txt;
    @FXML
    TextField txtfsearch;
    @FXML Button btninfor;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnsearch.setOnAction(event -> {
            username = txtfsearch.getText();
            try {
                client.dataOutputStream.writeUTF(username);
                txt.setText(client.dataInputStream.readUTF());

//                ArrayList<String> arr = new ArrayList<>();
//                arr = add.getPerson(username);
//                if(!arr.isEmpty()){
//                    txt.setText("ok");
//                }
//                else
//                    txt.setText("this user not exists");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }


//            txt.setText("your id is :");
        } catch (IOException e) {
                e.printStackTrace();
            }});
        btninfor.setOnAction(event -> {
//            try {
//                information.add(client.dataInputStream.readUTF());
//                information.add(client.dataInputStream.readUTF());
//                information.add(client.dataInputStream.readUTF());
//                information.add(client.dataInputStream.readUTF());
////                information.add(client.dataInputStream.readUTF());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        });
        btnnext.setOnAction(event -> {
            try {
               client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("GoTo.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
