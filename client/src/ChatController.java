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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    public  static String bn;
    public static int x;
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
    @FXML Button btnfile;
    String txt ="";
    int z=0;
    int counter=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
btnfile.setOnAction(event -> {
    FileChooser fc = new FileChooser();
    File selectedFile = fc.showOpenDialog(null);
    if (selectedFile != null) {
        String file = selectedFile.getPath();
        chat.setText(file);
        try {
            client.dataOutputStream.writeUTF(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});
btnsetting.setOnAction(event -> {
    try {
        client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
    } catch (IOException e) {
        e.printStackTrace();
    }
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
                    new Thread(() -> {

                        while (true){
                            btnsend.setOnAction(event -> {
                            try {
                                txt = txtfoutput.getText();
                                client.dataOutputStream.writeUTF(txt+"\n");
//                                if (z==0) {
//                                String client = Controller.etelagir.get(3);
                                txtfoutput.setText("");
                                    chat.appendText( ":" + txt);

//                                    z++;
//                                }
//                                    z=0;
//                                    txtfoutput.requestFocus();
//                        System.out.println(dataInputStream.readUTF());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            });
                        }
                    }).start();


        new Thread(() -> {
            while (true){
                try {
//                    String input =;
//                    if (counter==0) {
                        chat.appendText(Search.username + ":" +client.dataInputStream.readUTF() );
//                        counter++;
//                    }
//                        counter=0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        btnexit.setOnAction(event -> {
            System.exit(0);
        });
        btninformation.setOnAction(event -> {
            int x=1;
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("etelaat.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
