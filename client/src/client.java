import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client extends Thread {
    OutputStream output1;
    DataOutputStream dos;
    DataInputStream ir;
    InputStream input1;
    Socket socket;

    public client() {
        try {
            String host = "localhost";
            String serverAddress = "127.0.0.1";
            int port = 9090;
//            InetAddress ad = InetAddress.getByName(serverAddress);
            Socket socket = new Socket(serverAddress, port);
            Scanner scan1 = new Scanner(System.in);
            //input1=socket.getInputStream();
            //***********************************************************************************
            //ferestadan payam
            output1 = socket.getOutputStream();
            dos = new DataOutputStream(output1);
//            OutputStreamWriter ow = new OutputStreamWriter(output1);
//            BufferedWriter bw1 = new BufferedWriter(ow);
            String p = scan1.nextLine();
            dos.writeBytes(p);
   // dos.close();
    input1.close();
    ir.close();
//    output1.close();
//    socket.close();
//            bw1.write(p);
//            bw1.flush();
            //****************************************************************************
            //  gereftan payam
            input1 = socket.getInputStream();
            ir = new DataInputStream(input1);
            //BufferedReader br1 = new BufferedReader(ir);
            String m = ir.readLine();
            System.out.println(m);
    dos.close();
  //  input1.close();
  //  ir.close();
    output1.close();
   // socket.close();
//            //************************************************************************
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                dos.close();
                input1.close();
                ir.close();
                output1.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
