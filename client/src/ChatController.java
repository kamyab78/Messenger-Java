import com.vdurmont.emoji.EmojiParser;
import javafx.event.Event;
import javafx.event.EventHandler;
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

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    String smile = "\uD83D\uDE02";
    String cry = "\uD83D\uDE2D";
    String heart = "❤";
    String fear = "\uD83D\uDE31";
    String angry = "\uD83D\uDE21";
    public  static String bn;
    String dfile;
    ArrayList<String> files=new ArrayList<>();
    ArrayList<String >daryafti=new ArrayList<>();
    public static int x;
    Stage stage1 = new Stage();
    @FXML Button btncry;
    @FXML Button btnangry;
    @FXML Button btnheart;
    @FXML Button btnsmile;
    @FXML Button btnfear;
    @FXML Text txttype;
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
    @FXML Button btnpm;
    String txt ="";
    int z=0;
    int counter=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txttype.setText("online");
        Date date = new Date();
        String d=date.toString();
        btnpm.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("show.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnsmile.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.setText(EmojiParser.parseToUnicode(smile));
//            chat.appendText();
//            chat.appendText("");

        });
        btnangry.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.setText(EmojiParser.parseToUnicode(angry));
//            chat.appendText(EmojiParser.parseToUnicode(angry));
//            chat.appendText("");

        });
        btncry.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.setText(EmojiParser.parseToUnicode(cry));
//            chat.appendText(EmojiParser.parseToUnicode(cry));
//            chat.appendText("");

        });
        btnfear.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.setText(EmojiParser.parseToUnicode(fear));
//            chat.appendText(EmojiParser.parseToUnicode(fear));
//            chat.appendText("");

        });
        btnheart.setOnAction(event -> {
//            chat.appendText();
            txtfoutput.setText(EmojiParser.parseToUnicode(heart));
//            chat.appendText(EmojiParser.parseToUnicode(heart));
//            chat.appendText("");

        });
        btnfile.setOnAction(event -> {
    FileChooser fc = new FileChooser();
    File selectedFile = fc.showOpenDialog(null);
    if (selectedFile != null) {
        dfile = selectedFile.getPath();
       files.add(dfile) ;
//        chat.setText(dfile);
        try {
            client.dataOutputStream.writeUTF(dfile);
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
                                Addpayam ap = new Addpayam();
                                ap.addp(Start.username,Search.username,d,txt);
                                txtfoutput.setText("");
                                    chat.appendText( Start.username+":" + txt+"\n");

//                                    z++;
//                                }
//                                    z=0;
//                                    txtfoutput.requestFocus();
//                        System.out.println(dataInputStream.readUTF());
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
                client.dataOutputStream.writeUTF("is typing");
            } catch (IOException e) {
                e.printStackTrace();
            }
            });

chat.setOnMouseClicked(event -> {
    try {
        client.dataOutputStream.writeUTF("not");
    } catch (IOException e) {
        e.printStackTrace();
    }
});

        new Thread(() -> {
            while (true){
                try {
                    String input =client.dataInputStream.readUTF();
//                    if (counter==0) {
                    if (input.equals("\uD83D\uDE02")){
                        chat.appendText(EmojiParser.parseToUnicode(smile));
                    }
                    if (input.equals("\uD83D\uDE2D")){
                        chat.appendText(EmojiParser.parseToUnicode(cry));
                    }
                    if (input.equals("❤")){
                        chat.appendText(EmojiParser.parseToUnicode(heart));
                    }
                    if (input.equals("\uD83D\uDE31")){
                        chat.appendText(EmojiParser.parseToUnicode(fear));
                    }
                    if (input.equals("not")){
                        txttype.setText("online");
                    }
                    if (input.equals("is typing")){
                        txttype.setText("is typing.....");
                    }
                    if (input.equals("\uD83D\uDE21")){
                        chat.appendText(EmojiParser.parseToUnicode(angry));
                    }
                    if (!(input.equals("\uD83D\uDE21"))&& !(input.equals("\uD83D\uDE31")&&!(input.equals("❤"))&&!(input.equals("\uD83D\uDE2D")))&&!(input.equals("\uD83D\uDE02"))&&!(input.equals("is typing"))&&!(input.equals("not")))
                        chat.appendText(Search.username + ":" +input );
                    if ((input.charAt(0)=='C'&&input.charAt(1)==':')){
                        daryafti.add(input);
                    }
//if ((input.charAt(0). & input.charAt(1)=":")||
//                        counter++;
//                    }
//                        counter=0;
                    txtfoutput.appendText("");
                    txtfoutput.requestFocus();
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
