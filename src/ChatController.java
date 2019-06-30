import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
public class ChatController implements Initializable {
    public static String bn;
    public static int x = 0;
    Stage stage1 = new Stage();
    @FXML
    Button btnexit;
    @FXML
    TextField txtfoutput;
    @FXML
    Button btnsend;
    @FXML
    Text txtinformation;
    @FXML
    Button btninformation;
    @FXML
    TextArea chat;
    @FXML Button btnsetting;
    String txt = "";
    int counter = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date date = new Date();
        String oi = date.toString();
        chat.setEditable(false);
        try {
            add add = new add();
            String photo = add.getPerson(Search.username).get(4);
            Image image = new Image(new FileInputStream(photo));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(60);
            imageView.setFitWidth(60);
            btninformation.setGraphic(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (true) {
                btnsend.setOnAction(event -> {
                    try {
                        txt += txtfoutput.getText() + "\n\n";
//                    if (x == 0){
//                    String server = Controller.etelagir.get(3);
//                        chat.setText(server +":"+txt);
//                    x++;
//                }
                        server.dataOutputStream.writeUTF(txt);
                        String server = Controller.etelagir.get(3);
                        Addpayam addpaya = new Addpayam();
                        addpaya.addp(Controller.etelagir.get(3), txt, oi);
                        chat.setText(server + " : " + txt);
                        txtfoutput.setText("");
//                        txtfoutput.requestFocus();

//                        x=0;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }).start();

        new Thread(() -> {

            while (true) {
                try {
                    String str = server.dataInputStream.readUTF();
//                    if (counter==0) {
                    Addpayam addpayam = new Addpayam();
                    addpayam.addp(Search.username, str, oi);
                    String client = Search.username;
                    chat.setText(client + " : " + str);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        btnexit.setOnAction(event -> {
            System.exit(0);
        });
        btninformation.setOnAction(event -> {
            int x = 1;
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("etelaat.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnsetting.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
