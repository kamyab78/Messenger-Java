import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client extends Thread {
    String adressserver = "127.0.0.1";
    int port = 9090;
InputStream input1;
OutputStream output1;
DataInputStream read1;
PrintWriter wtite1;
    public client() {
        try {
            Socket socket = new Socket(adressserver, port);
            Scanner scan1 = new Scanner(System.in);
input1=socket.getInputStream();
output1=socket.getOutputStream();
            read1 = new DataInputStream(input1);
            wtite1=new PrintWriter(output1);
            while (true) {

                String javab1 = read1.readLine();
                System.out.println(javab1);
                String payam1 = scan1.nextLine();
                wtite1.write(payam1);
            }

        }
        catch (UnknownHostException e) {
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
