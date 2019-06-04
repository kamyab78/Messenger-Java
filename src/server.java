import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.Scanner;

public class server extends Thread {


    public server(){
        try {
            int portnumber = 9090;
            ServerSocket server = new ServerSocket(portnumber);

        while (true){

            Scanner scan = new Scanner(System.in);
            Socket connection = server.accept();
           InputStream input =connection.getInputStream();

           InputStreamReader inputreader = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(inputreader);
            String n = br.readLine();
            System.out.println(n);
            String returnmasage = scan.nextLine();
            OutputStream output =new ObjectOutputStream (connection.getOutputStream());
        OutputStreamWriter outputwriter = new OutputStreamWriter(output);
            BufferedWriter bw = new BufferedWriter(outputwriter);
            bw.write(returnmasage);
            bw.flush();
        }
        }
        catch (Exception e) {
       e.printStackTrace();
        }
//        finally {
//            try {
//                Socket.close();
//            }
//            catch (Exception e){
//
//            }
//        }
    }
}