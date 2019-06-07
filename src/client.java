import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.StringReader;
public class client {
    private String host;
    private int port;
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        new client ("127.0.0.1" , 9090).run();
    }
    public client(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void run() throws UnknownHostException, IOException{
        Socket socket = new Socket(host,port);
        System.out.println("connection is ok");
        PrintStream out = new PrintStream(socket.getOutputStream());
        System.out.print("enter name");
        String name = scan.nextLine();
        out.print(name);
        System.out.print("enter family name");
        String familyname = scan.nextLine();
        out.print(familyname);
        System.out.print("enter email");
        String email = scan.nextLine();
        out.print(email);
        System.out.print("enter user");
        String user = scan.nextLine();
        out.print(user);
        System.out.print("enter pass");
        String pass = scan.nextLine();
        out.print(pass);
        new Thread(new ReceivedMessagesHandler(socket.getInputStream())).start();
        System.out.println("payam: ");
        while (scan.hasNext()){
            out.print(scan.nextLine());
        }
        scan.close();
        out.close();
        socket.close();
    }
    class ReceivedMessagesHandler extends  Thread {
        private InputStream server;

        public ReceivedMessagesHandler(InputStream server) {
            this.server = server;
        }
//        public void run() {
//            Scanner m = new Scanner(server);
//
//        }
    }
}
