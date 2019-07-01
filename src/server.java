import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static javafx.scene.paint.Color.rgb;

public class server extends Application {
    public static Socket socket;
    public static  DataOutputStream dataOutputStream;
    public static  DataInputStream dataInputStream;
    public static ArrayList<String> etelaat = new ArrayList<>();
    public static ArrayList<BufferedImage> aks = new ArrayList<>();
    static Stage stage;
// static
    @Override
    public void start(Stage Stage) throws Exception {
        /***********************************************************************************************/
        /**sakhtan safe**/
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.setTitle("Messanger1");
        stage.alwaysOnTopProperty();
        /***********************************************************************************************/
        Stage.show();
    }



    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        String l = "";
        int counter = 0;
        int c = 0;
        socket = serverSocket.accept();
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataInputStream = new DataInputStream(socket.getInputStream());
        launch();
    }
}
//        System.out.println("1");
        /********************************************************************************************/
        /**etelaat nafar dovom ke hamon server hast**/
//        if (c == 0) {
//            System.out.println("1");
//            String Name = Controller.etelagir.get(0);
//            String Familyname = Controller.etelagir.get(1);
//            String Email = Controller.etelagir.get(2);
//            String Username = Controller.etelagir.get(3);
//            String Pass = Controller.etelagir.get(4);
//            String Photo = Controller.aks.get(0);
////            String Photo = Controller.etelagir.get(5);
////            File file = new File(Photo);
////            BufferedImage image = null;
////            image = ImageIO.read(file);
//            etela etela = new etela(Name, Familyname, Email, Username, Pass, Photo);
//            add ad = new add();
//            ad.addpersonofserver(etela);
//            c++;
//        }
//        if (counter == 0) {
//            /***********************************************************/
//            /**gerefan eltelaat az client va add kardan**/
//            DataInputStream is = new DataInputStream(socket.getInputStream());
//            String name = is.readUTF();
//            String familyname = is.readUTF();
//            String email = is.readUTF();
//            String user = is.readUTF();
//            String pass = is.readUTF();
//            String photo = is.readUTF();
//            counter++;
//            etelaa etelaa = new etelaa(name, familyname, email, user, pass, photo);
//            l = etelaa.getUser();
//            add add = new add();
//            add.addPerson(etelaa);
//            /*****************************************************************/
//        }
//        add s = new add();
//        s.getPerson(l);
//        final String finalL = l;
//
//        if (ChatController.x == 1) {
//            add add2 = new add();
//            add2.getPerson(l);
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true) {
//                    try {
//                        String str = dataInputStream.readUTF();
//                        System.out.println(str);
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(finalL, str, oi);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                while (true) {
//                    try {
//                        dataOutputStream.writeUTF(ChatController.bn);
//                        Addpayam addpaya = new Addpayam();
//                        addpaya.addp(finalL, ChatController.bn, oi);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();
//    }
//}
