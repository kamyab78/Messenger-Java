import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.Scanner;

public class server extends Thread {
    DataInputStream br;
    Socket connection;
    InputStream input;
    DataOutputStream bw;
    OutputStream output;
    int portnumber = 9090;
    ServerSocket server;

    public server() {
        try {
            while (true) {
                ServerSocket server = new ServerSocket(portnumber);
                Scanner scan = new Scanner(System.in);
                connection = server.accept();
                //*************************************************************
                //khandan payam
                input = connection.getInputStream();
                br = new DataInputStream(input);
                String n = br.readLine();
                System.out.println(n);

           // input.close();
            output.close();
            //br.close();
            bw.close();
//            server.close();
//            connection.close();
                //   **************************************************************
                //    ferestadan payam
                String returnmasage = scan.nextLine();
                output = connection.getOutputStream();
                bw = new DataOutputStream(output);
                bw.writeBytes(returnmasage);
                //********************************************************************
            input.close();
//            output.close();
            br.close();
//            bw.close();
      //      server.close();
 //           connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                br.close();
                bw.close();
                server.close();
                connection.close();
            } catch (Exception e) {

            }
        }
    }
}