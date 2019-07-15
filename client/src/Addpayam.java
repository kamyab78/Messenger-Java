import java.sql.*;
import java.util.ArrayList;

public class Addpayam {
    Connection connection;
    PreparedStatement preparedStatement;

    Addpayam() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger", "postgres", "Kamyab78");
    }

//    public void getPersons() throws Exception {
//        preparedStatement = connection.prepareStatement("select * from pm");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("username"));
//        }
//    }
public ArrayList <String>gettarikh(String username, String girande) throws Exception {
    preparedStatement = connection.prepareStatement("select tarikh from pm where (username=? AND girande=?) OR  (girande=? AND username=?)");
    preparedStatement.setString(1, username);
    preparedStatement.setString(2,girande);
    preparedStatement.setString(3,girande);
    preparedStatement.setString(4,username);
    ArrayList<String>tarikh=new ArrayList<>();
    ResultSet resultSet = preparedStatement.executeQuery();

//        System.out.println(resultSet.getString("username"));
    while ( resultSet.next())
        tarikh.add(resultSet.getString("tarikh"));
//        System.out.println(resultSet.getString("tarikh"));
    return tarikh;
}
    public ArrayList <String>getpm(String username, String girande) throws Exception {
        preparedStatement = connection.prepareStatement("select payam from pm where (username=? AND girande=?) OR  (girande=? AND username=?)");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2,girande);
        preparedStatement.setString(3,girande);
        preparedStatement.setString(4,username);
        ArrayList<String>payam=new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

//        System.out.println(resultSet.getString("username"));
        while ( resultSet.next())
            payam.add(resultSet.getString("payam"));
//        System.out.println(resultSet.getString("tarikh"));
        return payam;
    }


    public void addp(String user, String to, String date, String payam) throws Exception {
        preparedStatement = connection.prepareStatement("insert into pm values (default ,?,?,?,? )");
        // preparedStatement.setString(1,);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2, to);
        preparedStatement.setString(3, date);
        preparedStatement.setString(4,payam);
//        preparedStatement.setString(2,etelaa.getFamilyname());
//        preparedStatement.setString(3,etelaa.getEmail());
//        preparedStatement.setString(4,etelaa.getUser());
//        preparedStatement.setString(5 , etelaa.getPass());
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
