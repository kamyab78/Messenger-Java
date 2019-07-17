import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class History implements Initializable {
    @FXML Button btnsearch;
    @FXML
    TextField txtfsearch;
    @FXML
    TextArea txta;
    @FXML
    Text txt;

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
                    HashMap<Integer, String> times = new HashMap<>();
                    try {
                        Addpayam payam = new Addpayam();
                        for (int i = 0; i < payam.getpm(Start.username, username).size(); i++)
                            times.put(time(payam.gettarikh(Start.username, username).get(i)), payam.getpm(Start.username, username).get(i));
                        for (int i = 0; i < payam.getpm(username, Start.username).size(); i++)
                            times.put(time(payam.gettarikh(username, Start.username).get(i)), payam.getpm(username, Start.username).get(i));



                        List<Integer> timess = new ArrayList<>();
                        for (int i = 0; i < payam.getpm(Start.username, username).size(); i++)
                            timess.add(time(payam.gettarikh(Start.username, username).get(i)));

                        for (int i = 0; i < payam.getpm(username, Start.username).size(); i++)
                            timess.add(time(payam.gettarikh(username, Start.username).get(i)));



                        int temp = 0;
                        int finalytimes[] = new int[timess.size()];
                        for (int i = 0; i < timess.size(); i++)
                            finalytimes[i] = timess.get(i);

                        for (int i = 0; i < timess.size(); i++)
                            for (int j = 1; j < (timess.size() - i); j++)
                                if (finalytimes[j - 1] > finalytimes[j]) {
                                    //swap elements
                                    temp = finalytimes[j - 1];
                                    finalytimes[j - 1] = finalytimes[j];
                                    finalytimes[j] = temp;
                                }


                        for (int i = 0; i < times.size(); i++) {
                            System.out.println(times.get(finalytimes[i])+"\n");
                            txta.appendText(times.get(finalytimes[i])+"\n"+timeakhar(finalytimes[i]));
//                System.out.println(times.get(finalytimes[i]));
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
    public static int time(String in) {
        String un[] = in.split(" ");
        String un2[] = un[1].split(":");
        String finaltime = un2[0] + "" + un2[1] + un2[2];
        return Integer.parseInt(finaltime);
    }
    public static String timeakhar(int finaly){
        int first=finaly/10000;
        int h = finaly%10000;
        int dovom=h/100;
        int sevom=h%100;
        String akhar=(String.valueOf(first)+":"+String.valueOf(dovom)+":"+String.valueOf(sevom));
        return akhar;
    }
}
