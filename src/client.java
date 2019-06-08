import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost" , 9090);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        Scanner scan = new Scanner(System.in);
        /**************************************************/
        /**gereftan etelaat karbar**/
        System.out.print("enter name");
        String name = scan.nextLine();
        dataOutputStream.writeUTF(name);
//        out.println(name);
        System.out.print("enter family name");
        String familyname = scan.nextLine();
        dataOutputStream.writeUTF(familyname);
//        out.println(familyname);
        System.out.print("enter email");
        String email = scan.nextLine();
        dataOutputStream.writeUTF(email);
//        out.println(email);
        System.out.print("enter user");
        String user = scan.nextLine();
        dataOutputStream.writeUTF(user);
//        out.println(user);
        System.out.print("enter pass");
        String pass = scan.nextLine();
        dataOutputStream.writeUTF(pass);
        /******************************************************/

        final String[] m = new String[1];
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                  //  m[0] =dataInputStream.readUTF();
                   // if (m[0].equals("2"))
                    System.out.println(dataInputStream.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true){
           // if (!m[0].equals("2")) {
                dataOutputStream.writeUTF("1");
                dataOutputStream.writeUTF(scan.nextLine());
           // }

        }
    }

}
