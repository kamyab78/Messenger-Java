import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
//import org.json.JSONObject;
public class sms implements Initializable {
    public static String zakhireyecode;
    private static int code;
    public static String c;
    public static void call_me() throws Exception {
        c = createCode();
        String phone = Controller.phone;
//        String url = "https://api.kavenegar.com/v1/41456D6A7252713932764C483551494B7445554B776F592B4B6943526943524956724F475055546D6A6A413D/sms/send.json?receptor="+phone+"&sender=10004346&message="+c;
        String url = "http://37.130.202.188/class/sms/webservice/send_url.php?from=5000189&to="+ phone+"&msg="+c+"&uname=09213897125&pass=0017392047";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
//        //print in String
        System.out.println(response.toString());
//        //Read JSON response and print
//        JSONObject myResponse = new JSONObject(response.toString());
//        System.out.println("result after Reading JSON Response");
//        System.out.println("statusCode- "+myResponse.getString("statusCode"));
//        System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
//        System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
//        System.out.println("countryCode- "+myResponse.getString("countryCode"));
//        System.out.println("countryName- "+myResponse.getString("countryName"));
//        System.out.println("regionName- "+myResponse.getString("regionName"));
//        System.out.println("cityName- "+myResponse.getString("cityName"));
//        System.out.println("zipCode- "+myResponse.getString("zipCode"));
//        System.out.println("latitude- "+myResponse.getString("latitude"));
//        System.out.println("longitude- "+myResponse.getString("longitude"));
//        System.out.println("timeZone- "+myResponse.getString("timeZone"));
    }
    public static String createCode() {
        code = new Random().nextInt(99999 - 10000 + 1) + 10000;
        String cod = String.valueOf(code);
        zakhireyecode = String.valueOf(code);
        return cod;
    }

    @FXML
    Button btnnext;
    @FXML Button btntest;
    @FXML
    Text txt;
    @FXML
    TextField txtfsms;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            sms.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btntest.setOnAction(event -> {
                if (zakhireyecode.equals(txtfsms.getText())) {
                    txt.setText("ok");
                    btnnext.setOnAction(event1 -> {
                        try {
                            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("start.fxml"))));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                } else
                    txt.setText("code is not valid");
            });

    }
}