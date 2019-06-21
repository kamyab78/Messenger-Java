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
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("controll.fxml"));
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.setTitle("Messanger");
        primaryStage.show();
    }
        public static void main(String[] args) throws IOException {
        launch(args);
        Socket socket = new Socket("localhost" , 9090);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        Scanner scan = new Scanner(System.in);
        /**************************************************/
        /**gereftan etelaat karbar**/
        System.out.print("enter name");
        dataOutputStream.writeUTF(Controller.etelaat.get(0));
        System.out.print("enter family name");
        dataOutputStream.writeUTF(Controller.etelaat.get(1));
        System.out.print("enter email");
        dataOutputStream.writeUTF(Controller.etelaat.get(2));
        System.out.print("enter user");
            dataOutputStream.writeUTF(Controller.etelaat.get(3));
        System.out.print("enter pass");
            dataOutputStream.writeUTF(Controller.etelaat.get(4));
            System.out.println("enter your directory of photo");
dataOutputStream.writeUTF(Controller.etelaat.get(5));
        List list = new ArrayList<>();
        /******************************************************/
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        dataOutputStream.writeUTF(conection.z);
//                        System.out.println(dataInputStream.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        System.out.println(dataInputStream.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
