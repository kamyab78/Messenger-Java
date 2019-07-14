import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client extends Application {
    static Stage stage;
    public static Socket socket;
    public static DataInputStream dataInputStream;
    public static DataOutputStream dataOutputStream;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Messanger");
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {

        socket = new Socket("localhost", 9090);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        launch(args);
        Scanner scan = new Scanner(System.in);
        /**************************************************/
        /**gereftan etelaat karbar**/
//        System.out.print("enter name");
//
//        System.out.print("enter family name");
//
//        System.out.print("enter email");
//
//        System.out.print("enter user");
//
//        System.out.print("enter pass");
//
//            System.out.println("enter your directory of photo");
////dataOutputStream.writeUTF(Controller.etelaat.get(5));
//        List list = new ArrayList<>();
        /******************************************************/
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true){
//                    try {
//                        dataOutputStream.writeUTF(conection.z);
////                        System.out.println(dataInputStream.readUTF());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true){
//                    try {
//                        System.out.println(dataInputStream.readUTF());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//    }
    }
}
