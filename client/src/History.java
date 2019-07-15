import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class History implements Initializable {
    @FXML Button btnsearch;
    @FXML
    TextField txtfsearch;
    @FXML
    TextArea txta;
    @FXML
    Text txt;
    @FXML TextArea txtarea;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnsearch.setOnAction(event -> {
            String username=txtfsearch.getText();
            try {
                add add = new add();
                ArrayList<String>a=add.getPerson(username);
                if(a.isEmpty()){
                    txt.setText("this user not exsist");
                }
                if (!(a.isEmpty())){
                    txt.setText("");
                    try {
                        Addpayam ap = new Addpayam();
                        txta.appendText(Start.username+":");
                        for (int i = 0; i <ap.getpm(Start.username,username).size() ; i++) {
                            txta.appendText(ap.getpm(Start.username,username).get(i)+"\n"+ap.gettarikh(Start.username,username).get(i)+"\n");
//                            txtarea.appendText(ap.gettarikh(Start.username,username).get(i)+"\n");
                        }
                        txta.appendText( Search.username+":");
                        for (int i = 0; i <ap.getpm(username,Start.username).size() ; i++) {
                            txta.appendText(ap.getpm(username,Start.username).get(i)+"\n"+ap.gettarikh(username,Start.username).get(i)+"\n");
//                            txtarea.appendText(ap.gettarikh(username,Start.username).get(i)+"\n");
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
