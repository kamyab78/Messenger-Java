import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
public class server {
    private int port = 9090;
    private List<User> client;
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        new server(9090).run();
    }

    public server(int port) {
        this.port = port;
        this.client = new ArrayList<User>();
    }

    public void run() throws IOException {
        serverSocket = new ServerSocket(port){

        protected void finalize() throws IOException {
            this.close();
        }
        };

        while (true) {
            Socket socket = serverSocket.accept();
            String name = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(name + " ");
            System.out.println( );
            String familyname = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(familyname + " ");
            System.out.println( );
            String email = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(email+ " ");
            System.out.println( );
            String user = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(user + " ");
            System.out.println( );
            String pass = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(pass+ " ");
            System.out.println( );
            String payam = (new Scanner(socket.getInputStream())).nextLine();
            System.out.println(payam + " ");
            System.out.println( );
            User newUser = new User(socket, name, familyname, email, user, pass);
           client.add(newUser);
//        newUser.getOutStream();
        new Thread(new UserHandler(this, newUser)).start();
        }
    }

    class UserHandler extends Thread {
        private server server;
        private User user;

        public UserHandler(server server, User user) {
            this.server = server;
            this.user = user;
        }
    }
        class User {

            private PrintStream streamOut;
            private InputStream streamIn;
            private String name;
            private String familyname;
            private String email;
            private String user;
            private String pass;
            private Socket client;


            public User(Socket client, String name, String familyname, String email, String user, String pass) throws IOException {
                this.streamOut = new PrintStream(client.getOutputStream());
                this.streamIn = client.getInputStream();
                this.client = client;
                this.name = name;
                this.familyname = familyname;
                this.email = email;
                this.user = user;
                this.pass = pass;
            }

            public PrintStream getStreamOut() {
                return streamOut;
            }

            public InputStream getStreamIn() {
                return streamIn;
            }

            public String getName() {
                return name;
            }

            public String getFamilyname() {
                return familyname;
            }

            public String getEmail() {
                return email;
            }

            public String getUser() {
                return user;
            }

            public String getPass() {
                return pass;
            }
        }

    }

