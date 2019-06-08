import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    Socket socket;
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        int counter = 0;
        while (true){
            Socket socket =serverSocket.accept();
            if(counter == 0){
                /***********************************************************/
                /**gerefan eltelaat az client va add kardan**/
                DataInputStream is = new DataInputStream(socket.getInputStream());
                String name = is.readUTF();
                //System.out.println(name);
                String familyname = is.readUTF();
                String email = is.readUTF();
                String user = is.readUTF();
                String pass = is.readUTF();
                counter ++;
                etelaa etelaa = new etelaa(name , familyname , email , user , pass);
                add add = new add();
                add.addPerson(etelaa);
                /*****************************************************************/
            }
                new Thread(new chat(socket)).start();
        }
    }
    static class chat implements Runnable{
        Socket socket;
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        Scanner scanner;
        chat(Socket socket ) throws IOException {
            this.socket=socket;
            dataInputStream=new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            scanner=new Scanner(System.in);
        }

        @Override
        public void run() {
            while (true){
                try {
                    String desicion = dataInputStream.readUTF();
                    if (desicion.equals("1"))
                        System.out.println(dataInputStream.readUTF());

                    else {
                        dataOutputStream.writeUTF("2");
                        dataOutputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }
}
