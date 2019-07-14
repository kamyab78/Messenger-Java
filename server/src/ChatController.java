import com.vdurmont.emoji.EmojiParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
public class ChatController implements Initializable {
    public static String bn;
    public static int x = 0;
    String smile = "\uD83D\uDE02";
    String cry = "\uD83D\uDE2D";
    String heart = "❤";
    String fear = "\uD83D\uDE31";
    String angry = "\uD83D\uDE21";
    Stage stage1 = new Stage();
    @FXML Button btncry;
    @FXML Button btnangry;
    @FXML Button btnheart;
    @FXML Button btnfear;
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
    Button btnfile;
    @FXML
    TextArea chat;
    @FXML
    Button btnsetting;
    @FXML Button btnsmile;
    String txt = "";
    int counter = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date date = new Date();
        String oi = date.toString();
        btnsmile.setOnAction(event -> {
//            chat.appendText();
            chat.appendText(EmojiParser.parseToUnicode(smile));
//            chat.appendText("");

        });
        btnangry.setOnAction(event -> {
//            chat.appendText();
            chat.appendText(EmojiParser.parseToUnicode(angry));
//            chat.appendText("");

        });
        btncry.setOnAction(event -> {
//            chat.appendText();
            chat.appendText(EmojiParser.parseToUnicode(cry));
//            chat.appendText("");

        });
        btnfear.setOnAction(event -> {
//            chat.appendText();
            chat.appendText(EmojiParser.parseToUnicode(fear));
//            chat.appendText("");

        });
        btnheart.setOnAction(event -> {
//            chat.appendText();
            chat.appendText(EmojiParser.parseToUnicode(heart));
//            chat.appendText("");

        });

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
//        try {
//            server.dataInputStream.readUTF();
//            JSONObject jo = new JSONObject();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        new Thread(() -> {
            while (true) {
                btnsend.setOnAction(event -> {
                    try {
                        txt = txtfoutput.getText();
//                    if (x == 0){
//                    String server = Controller.etelagir.get(3);
//                        chat.appendText(server +":"+txt);
//                    x++;
//                }
                        server.dataOutputStream.writeUTF(txt+"\n");
                        String server =Start.username;
                        Addpayam addpaya = new Addpayam();
                        addpaya.addp(server, txt, oi);
                        txtfoutput.appendText("");
                        chat.appendText(server + " : " + txt);
//                        txtfoutput.appendText("");
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
                    txtfoutput.appendText("");
                    chat.appendText(client + " : " + str);

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
        btnfile.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            if (selectedFile != null) {
                String file = selectedFile.getPath();
                chat.appendText(file);
                try {
                    server.dataOutputStream.writeUTF(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
