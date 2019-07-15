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
//            new Thread(()-> {
//while (true){
//    try {
//        String name=server.dataInputStream.readUTF();
//        String family=server.dataInputStream.readUTF();
//        String email=server.dataInputStream.readUTF();
//        String user=server.dataInputStream.readUTF();
//        String pass=server.dataInputStream.readUTF();
//        String photo=server.dataInputStream.readUTF();
//        etelaa etelaa = new etelaa(name,family,email,user,pass,photo);
//        add add=new add();
//        add.addPerson(etelaa);
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//            }).start();
//            if (!ar.isEmpty()){
//                server.dataOutputStream.writeUTF("ok");
//                server.dataOutputStream.writeUTF(a.getPerson(user).get(0));
//                server.dataOutputStream.writeUTF(a.getPerson(user).get(1));
//                server.dataOutputStream.writeUTF(a.getPerson(user).get(2));
//                server.dataOutputStream.writeUTF(a.getPerson(user).get(3));
//                server.dataOutputStream.writeUTF(a.getPerson(user).get(4));
//            }
//            else
//                server.dataOutputStream.writeUTF("this user not exist");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnchat.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("history.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnsearch.setOnAction(event -> {
            username = txtfsearch.getText();
//            client.
            try {
                add add = new add();
                ArrayList<String> arr = new ArrayList<>();
                arr = add.getPerson(username);
                if(!arr.isEmpty()){
                    txt.setText("ok");
                }
                else
                    txt.setText("this user not exists");
            } catch (Exception e) {
                e.printStackTrace();
            }


//            txt.setText("your id is :");
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
