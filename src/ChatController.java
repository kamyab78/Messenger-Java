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
    String txt ="";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chat.setEditable(false);
//        try {
//            add add = new add();
//            String photo = add.getPerson(Search.username).get(4);
//            Image image = new Image(new FileInputStream(photo));
//            ImageView imageView = new ImageView(image);
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(60);
//            btninformation.setGraphic(imageView);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        btnsend.setOnAction(event -> {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            while (true){
                                try {
                                    txt += txtfoutput.getText() + "\n\n";
                                    client.dataOutputStream.writeUTF(txt);
                                    chat.setText(txt);
                                    txtfoutput.setText("");
//                                    txtfoutput.requestFocus();
//                        System.out.println(dataInputStream.readUTF());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
        );
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        String input =client.dataInputStream.readUTF();
                        chat.setText(input);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        btnexit.setOnAction(event -> {
            System.exit(0);
        });
//        btninformation.setOnAction(event -> {
//            int x=1;
//            try {
//                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("etelaat.fxml"))));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
