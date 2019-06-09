import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class add {
    Connection connection;
    PreparedStatement preparedStatement;
    add() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger","postgres","Kamyab78");
    }
    public void getPersons() throws Exception{
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
    }

    public void getPerson(String name) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where username=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString("name"));
        System.out.println(resultSet.getString("familyname"));
        System.out.println(resultSet.getString("email"));
        System.out.println(resultSet.getString("username"));
        System.out.println(resultSet.getString("pass"));

    }

    public void addPerson(etelaa etelaa) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?)");
        preparedStatement.setString(1,etelaa.getName());
        preparedStatement.setString(2,etelaa.getFamilyname());
        preparedStatement.setString(3,etelaa.getEmail());
        preparedStatement.setString(4,etelaa.getUser());
        preparedStatement.setString(5 , etelaa.getPass());
        preparedStatement.executeUpdate();
    }

    public void editePerson(String newname,String newfamilyname , String newemail , String newuser , String newpass) throws Exception{
        preparedStatement = connection.prepareStatement("update person values (default , ?,?,?,?,?) where username=?");
        preparedStatement.setString(1,newname);
        preparedStatement.setString(2,newfamilyname);
        preparedStatement.setString(3,newemail);
        preparedStatement.setString(4,newuser);
        preparedStatement.setString(5,newpass);
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
