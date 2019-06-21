import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Etelaat implements Initializable {
    @FXML
    Button btnback;
    @FXML
    Button btnshow;
    @FXML
    Text txtname;
    @FXML
    Text txtfamily;
    @FXML
    Text txtemail;
    @FXML
    Text txtuser;
@FXML
    ImageView img;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnshow.setOnAction(event -> {

            try {
                add add = new add();
                txtname.setText(add.getPerson(Search.username).get(0));
                txtfamily.setText(add.getPerson(Search.username).get(1));
                txtemail.setText(add.getPerson(Search.username).get(2));
                txtuser.setText(add.getPerson(Search.username).get(3));
                String photo = add.getPerson(Search.username).get(4);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            File file = new File(photo);
//            BufferedImage image = null;
//            try {
//                image = ImageIO.read(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            img.setImage(new Image(photo));
//            img.
//            img.getImage();
        });
//
//        text.setText("a");


        btnback.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Go.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
