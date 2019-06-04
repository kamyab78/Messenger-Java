import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner etela = new Scanner(System.in);
        String name = etela.nextLine();
        String family=etela.nextLine();
        String email = etela.nextLine();
        String user=etela.nextLine();
        String pass=etela.nextLine();
        etelaat etelaat = new etelaat(name , family , email , user , pass);
        namayesh namayesh = new namayesh();
        namayesh.addPerson(etelaat);
        new server();
        new client();
    }
}
