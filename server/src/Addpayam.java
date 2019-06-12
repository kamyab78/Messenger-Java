import java.sql.*;

public class Addpayam {
    Connection connection;
    PreparedStatement preparedStatement;

    Addpayam() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger", "postgres", "Kamyab78");
    }

    public void getPersons() throws Exception {
        preparedStatement = connection.prepareStatement("select * from payam");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
    }

    public void getPerson(String username) throws Exception {
        preparedStatement = connection.prepareStatement("select * from payam where username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString("username"));
        System.out.println(resultSet.getString("payam"));
        System.out.println(resultSet.getString("tarikh"));

    }


    public void addp(String user, String payam, String date) throws Exception {
        preparedStatement = connection.prepareStatement("insert into payam values (default ,?,?,? )");
       // preparedStatement.setString(1,);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2, payam);
       preparedStatement.setString(3, date);

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
