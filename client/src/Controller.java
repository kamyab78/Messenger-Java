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
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

public class Controller implements Initializable {
    public static ArrayList<String> etelagir = new ArrayList<>();
    public static ArrayList<String> aks = new ArrayList<>();
    public static String phone;
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
    Button btnemail;
    @FXML Button btnsms;
    @FXML TextField txtfphone;
    @FXML
    TextField txtfphoto;
    @FXML
    Text txt;
    @FXML Button btnsubmit;
    @FXML Text txts;
    @FXML Button btnphoto;
    List<String> strings;
    String username;
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
            phone=txtfphone.getText();

            txts.setText("your submit is ok;Lets Go");
            etelaa etelaa = new etelaa(name,familyname,email,username,pass,aks.get(0));
            try {
                add add = new add();
                add.addPerson(etelaa);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            new Thread(()->{
//
////                try {
//            try {
//                client.dataOutputStream.writeUTF(name);
//                client.dataOutputStream.writeUTF(familyname);
//                client.dataOutputStream.writeUTF(email);
//                client.dataOutputStream.writeUTF(username);
//                client.dataOutputStream.writeUTF(pass);
//                client.dataOutputStream.writeUTF(aks.get(0));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }).start();

//            JSONObject jo = new JSONObject();
//            JSONArray ja = new JSONArray();
//            jo.put("name", etelagir.get(0));
//            jo.put("familyname", etelagir.get(1));
//            jo.put("email", etelagir.get(2));
//            jo.put("username", etelagir.get(3));
//            jo.put("pass", etelagir.get(4));
//            jo.put("photo", etelagir.get(5));

//            try {
//                client.dataOutputStream.writeUTF( jo.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            PrintWriter pw = null;
//            try {
//                pw = new PrintWriter("JSONExample.json");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            pw.write(jo.toJSONString());

//            pw.flush();
//            pw.close();
//            jo.put("name", etelagir.get(0));
//            jo.put("name", etelagir.get(0));
        });
        btnsms.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sms.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnemail.setOnAction(event -> {
//            try {
//                DataInputStream is = new DataInputStream(client.socket.getInputStream());
//                username=is.readUTF();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {

                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("email.fxml"))));
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
