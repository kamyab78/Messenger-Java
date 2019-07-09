import java.sql.*;
import java.util.ArrayList;

public class add {
//    public static
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    add() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger","postgres","Kamyab78");
    }
    public ArrayList<String> getPerson(String username) throws Exception{
//        statement = connection.createStatement();
//        String sql;
//        sql = "select * from person where username=" + username;
//        ResultSet resultSet = statement.executeQuery(sql);
//
        preparedStatement = connection.prepareStatement("select * from person where username=?");
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
        ArrayList<String>infor = new ArrayList<>();
//        if( resultSet.next()) {
        if(resultSet.next()) {

            infor.add(resultSet.getString("name"));
            infor.add(resultSet.getString("familyname"));
            infor.add(resultSet.getString("email"));
            infor.add(resultSet.getString("username"));
            infor.add(resultSet.getString("photo"));
            infor.add(resultSet.getString("pass"));
        }
//
        return infor;
//        etelaa user = new etelaa(resultSet.getString("name"), resultSet.getString("familyname"), resultSet.getString("email"),resultSet.getString("username"),null , resultSet.getString("photo"));
    }

    public void addPerson(etelaa etelaa) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?,?)");
        preparedStatement.setString(1,etelaa.getName());
        preparedStatement.setString(2,etelaa.getFamilyname());
        preparedStatement.setString(3,etelaa.getEmail());
        preparedStatement.setString(4,etelaa.getUser());
        preparedStatement.setString(5 , etelaa.getPass());
        preparedStatement.setString(6,etelaa.getPhoto());
        preparedStatement.executeUpdate();
    }
    public void addpersonofserver(etela etela) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?,?)");
        preparedStatement.setString(1,etela.getName());
        preparedStatement.setString(2,etela.getFamilyname());
        preparedStatement.setString(3,etela.getEmail());
        preparedStatement.setString(4,etela.getUsername());
        preparedStatement.setString(5 , etela.getPass());
        preparedStatement.setString(6,etela.getPhoto());
        preparedStatement.executeUpdate();
    }

    public void editePerson(String username , String newname,String newfamilyname , String newemail , String newuser , String newpass , String newphoto) throws Exception{
        preparedStatement = connection.prepareStatement("update person set name=?,familyname=?,email=?,username=?,pass=?,photo=?,where username=?");
//        preparedStatement.setString(1,username);
        preparedStatement.setString(1,newname);
        preparedStatement.setString(2,newfamilyname);
        preparedStatement.setString(3,newemail);
        preparedStatement.setString(4,newuser);
        preparedStatement.setString(5,newpass);
        preparedStatement.setString(6,newphoto);
        preparedStatement.setString(7,username);
        preparedStatement.executeUpdate();
    }
    public void deletePerson(String username) throws Exception{
        preparedStatement = connection.prepareStatement("delete from person where username = ?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }
    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
