import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client extends Thread {
    public client() {
        try {
            String host = "localhost";
            int port = 9090;
            InetAddress ad = InetAddress.getByName(host);
            Socket socket = new Socket(ad, port);
            Scanner scan1 = new Scanner(System.in);
            //input1=socket.getInputStream();
            OutputStream output1=socket.getOutputStream();
            OutputStreamWriter ow = new OutputStreamWriter(output1);
            BufferedWriter bw1 = new BufferedWriter(ow);
String p = scan1.nextLine();
bw1.write(p);
bw1.flush();
InputStream input1 = socket.getInputStream();
InputStreamReader ir = new InputStreamReader(input1);
BufferedReader br1 = new BufferedReader(ir);
String m = br1.readLine();
            System.out.println(m);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
//finally {
//            try {
//                Socket.close();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }

    }
}
