import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    public static ArrayList<String> etelagir = new ArrayList<>();
    public static ArrayList<String> aks = new ArrayList<>();
    public  static String phone;
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
    @FXML
    TextField txtfphoto;
    @FXML
    Text txt;
    @FXML Button btnsubmit;
    @FXML Text txts;
    @FXML Button btnphoto;
    @FXML Button btnsms;
    @FXML TextField txtfphone;

    List<String> strings;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 btnphoto.setOnAction(event -> {
FileChooser fc = new FileChooser();
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
//            pass=amniat.encrypt(pass);
            etelagir.add(pass);
            String Photo;
            Photo = null;
            phone = txtfphone.getText();
            Date date =new Date();
            SimpleDateFormat format1=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            String tarikh= format1.format(date);
            try {
                tout tout = new tout();
                tout.addtime(username,tarikh);
            } catch (Exception e) {
                e.printStackTrace();
            }
            txts.setText("your submit is ok;Lets Go");
            etela etela = new etela(name , familyname , email , username , pass , aks.get(0));
            try {
                add a = new add();
                a.addpersonofserver(etela);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnemail.setOnAction(event -> {
            try {
//            DataInputStream is = new DataInputStream(server.socket.getInputStream());
//            String name = is.readUTF();
//            String familyname = is.readUTF();
//            String email = is.readUTF();
//            String user = is.readUTF();
//            String pass = is.readUTF();
//            String photo = is.readUTF();
//            etelaa etelaa = new etelaa(name, familyname, email, user, pass, photo);
////
//            add add = new add();
//            add.addPerson(etelaa);
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("email.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            server.stage.show();
        });
        btnsms.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sms.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
