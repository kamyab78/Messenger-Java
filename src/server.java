import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class server extends Thread {
    int portnumber = 9090;
    Socket connection;
    ObjectInputStream input;
    ObjectOutputStream output;
    DataInputStream read;
    PrintWriter write;

    public server(){
        try {
            Scanner scan = new Scanner(System.in);
            ServerSocket server = new ServerSocket(portnumber);
            Socket connection = server.accept();
            input =new ObjectInputStream (connection.getInputStream());
            output =new ObjectOutputStream (connection.getOutputStream());

read = new DataInputStream(input);
write= new PrintWriter(output);
while (true) {
    String payam = scan.nextLine();
    if (payam.equals("exit")){
        break;

    }
    else {
        write.println(payam);
        String javab = read.readLine();
        System.out.println(javab);

    }
}
connection.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}