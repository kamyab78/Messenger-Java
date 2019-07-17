import com.vdurmont.emoji.EmojiParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import static javax.swing.text.html.HTML.Tag.DD;
import static javax.xml.datatype.DatatypeConstants.DATETIME;

public class ChatController implements Initializable {
    public static String bn;
    public static int x = 0;
    String smile = "\uD83D\uDE02";
    String cry = "\uD83D\uDE2D";
    String heart = "❤";
    String fear = "\uD83D\uDE31";
    String angry = "\uD83D\uDE21";
    Stage stage1 = new Stage();
    ArrayList<String>files=new ArrayList<>();
    String dfile;
    @FXML Button btncry;
    @FXML Button btnangry;
    @FXML Button btnheart;
    @FXML Button btnpm;
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
    @FXML Text txttype;
    @FXML
    Button btnsetting;
    @FXML Button btnsmile;
    @FXML Button btnshow;
    @FXML Button sendfile;
    @FXML private ProgressBar pb;
   class bg_Thread implements Runnable{
       @Override
       public void run() {
           for (int i = 0; i <100 ; i++) {
               pb.setProgress(i/100.0);
           }
           try {
               Thread.sleep(3000);
               pb.setProgress(0.0);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
    String txt = "";
    int counter = 0;
ArrayList<String >daryafti=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pb.setProgress(0.0);
//        String format="YYYY-MM-DD";
//
            Date date =new Date();
        SimpleDateFormat format1=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String tarikh= format1.format(date);
//        hamzamani hamzamani= null;
        try {
           hamzamani hamzamani = new hamzamani();
            if (hamzamani.getsl().equals(hamzamani.gets4())&&hamzamani.gets2().equals(hamzamani.gets3())){
                txttype.setText("online");
            }
            else {
                tout tout = new tout();
                txttype.setText(tout.seen(Search.username));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//                    if (counter==0) {

        txttype.setText("online");
        btnpm.setOnAction(event -> {
            try {
                server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("show.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnsmile.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.appendText(EmojiParser.parseToUnicode(smile));
//            chat.appendText();
//            chat.appendText("");

        });
        btnangry.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.appendText(EmojiParser.parseToUnicode(angry));
//            chat.appendText(EmojiParser.parseToUnicode(angry));
//            chat.appendText("");

        });
        btncry.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.appendText(EmojiParser.parseToUnicode(cry));
//            chat.appendText(EmojiParser.parseToUnicode(cry));
//            chat.appendText("");

        });
        btnfear.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.appendText(EmojiParser.parseToUnicode(fear));
//            chat.appendText(EmojiParser.parseToUnicode(fear));
//            chat.appendText("");

        });
        btnheart.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.appendText(EmojiParser.parseToUnicode(heart));
//            chat.appendText(EmojiParser.parseToUnicode(heart));
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
                        final String secretKey = "khafe";
                        server.dataOutputStream.writeUTF(txt+"\n");
                        String server =Start.username;
                        Addpayam addpaya = new Addpayam();
                        addpaya.addp(server,Search.username ,tarikh ,txt);
                        txtfoutput.appendText("");
                        chat.appendText(server + " : " + txt+"\n");



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
        txtfoutput.setOnMouseClicked(event -> {
            try {
                server.dataOutputStream.writeUTF("is typing");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        chat.setOnMouseClicked(event -> {
            try {
                server.dataOutputStream.writeUTF("not");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(() -> {

            while (true) {
                try {
//                    String str = server.dataInputStream.readUTF();
                    final String secretKey = "khafe";
                    String input = server.dataInputStream.readUTF();
//                    System.out.println(input);
//                     String input=AES.decrypt(i,secretKey);
//                    System.out.println(input);
                    hamzamani hamzamani=new hamzamani();
//                    if (counter==0) {
if (hamzamani.getsl().equals(hamzamani.gets4())&&hamzamani.gets2().equals(hamzamani.gets3())) {
    if (input.equals("\uD83D\uDE02")) {
        chat.appendText(Search.username + ":" + EmojiParser.parseToUnicode(smile));
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(Search.username,Start.username , input, oi );
//                        String client = Search.username;
//                        chat.appendText(client + " : " + input + "\n");
        txtfoutput.appendText("");

    }
    if (input.equals("\uD83D\uDE2D")) {
        chat.appendText(Search.username + ":" + EmojiParser.parseToUnicode(cry));
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(Search.username, input, oi, Start.username);
//                        String client = Search.username;
//                        chat.appendText(client + " : " + input + "\n");
        txtfoutput.appendText("");

    }
    if (input.equals("❤")) {
        chat.appendText(Search.username + ":" + EmojiParser.parseToUnicode(heart));
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(Search.username, input, oi, Start.username);
//                        String client = Search.username;
//                        chat.appendText(client + " : " + input + "\n");
        txtfoutput.appendText("");

    }
    if (input.equals("\uD83D\uDE31")) {
        chat.appendText(Search.username + ":" + EmojiParser.parseToUnicode(fear));
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(Search.username, input, oi, Start.username);
//                        String client = Search.username;
//                        chat.appendText(client + " : " + input + "\n");
        txtfoutput.appendText("");

    }
    if (input.equals("\uD83D\uDE21")) {
        chat.appendText(Search.username + ":" + EmojiParser.parseToUnicode(angry));
//                        Addpayam addpayam = new Addpayam();
//                        addpayam.addp(Search.username, input, oi, Start.username);
//                        String client = Search.username;
//                        chat.appendText(client + " : " + input + "\n");
        txtfoutput.appendText("");

    }
    if (input.equals("not")) {
        txttype.setText("online");
    }
    if (input.equals("is typing")) {
        txttype.setText("is typing.....");
    }
    if (!(input.equals("\uD83D\uDE21")) && !(input.equals("\uD83D\uDE31") && !(input.equals("❤")) && !(input.equals("\uD83D\uDE2D"))) && !(input.equals("\uD83D\uDE02")) && !(input.equals("is typing")) && !(input.equals("not"))) {
        chat.appendText(Search.username + ":" + input);
//                    Addpayam addpayam = new Addpayam();
//                    addpayam.addp(Search.username, input, oi, Start.username);
//                    String client = Search.username;
//                    chat.appendText(client + " : " + input + "\n");
//                            txtfoutput.appendText("");
//                            txtfoutput.requestFocus();
    }
    if ((input.charAt(0) == 'C' && input.charAt(1) == ':')) {
        daryafti.add(input);
    }
}
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
                dfile = selectedFile.getPath();
                files.add(dfile);
//                chat.appendText(file);

            }
        });
sendfile.setOnAction(event -> {
    System.out.println("1");
    Thread th=new Thread(new bg_Thread());
    th.start();
    try {
        server.dataOutputStream.writeUTF(dfile);
    } catch (IOException e) {
        e.printStackTrace();
    }
//    try {
//        Thread.sleep(1000);
//        pb.setProgress(0.0);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }

});

        btnshow.setOnAction(event -> {
            File file = new File(dfile);

            //first check if Desktop is supported by Platform or not
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
                return;
            }

            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //let's try to open PDF file
            file = new File(dfile);
            if(file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    public void mouse1(MouseEvent mouseEvent) {
        File file = new File(files.get(0));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(0));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouse2(MouseEvent mouseEvent) {
        File file = new File(files.get(1));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(1));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouse3(MouseEvent mouseEvent) {
        File file = new File(files.get(2));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(2));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouse4(MouseEvent mouseEvent) {
        File file = new File(files.get(3));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(3));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouse5(MouseEvent mouseEvent) {
        File file = new File(files.get(4));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(4));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouse6(MouseEvent mouseEvent) {
        File file = new File(files.get(5));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(files.get(5));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses1(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(0));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(0));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses2(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(1));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(1));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses3(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(2));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(2));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses4(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(3));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(3));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses5(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(4));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(4));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mouses6(MouseEvent mouseEvent) {
        File file = new File(daryafti.get(5));

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //let's try to open PDF file
        file = new File(daryafti.get(5));
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
