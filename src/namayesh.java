//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class namayesh {
//    Connection connection;
//    PreparedStatement preparedStatement;
//    namayesh() throws Exception{
//        Class.forName("org.postgresql.Driver");
//        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=proj","postgres","Kamyab78");
//    }
//    public void getPersons() throws Exception{
//        preparedStatement = connection.prepareStatement("select * from person");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("username"));
//        }
//    }
//
//    public void getPerson(String name) throws Exception{
//        preparedStatement = connection.prepareStatement("select * from person where name=?");
//        preparedStatement.setString(1,name);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        System.out.println(resultSet.getString("name"));
//        System.out.println(resultSet.getString("familyname"));
//        System.out.println(resultSet.getString("username"));
//
//    }
//
//    public void addPerson(etelaat etelaat) throws Exception{
//        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?)");
//        preparedStatement.setString(1,etelaat.getName());
//        preparedStatement.setString(2,etelaat.getFamilyname());
//        preparedStatement.setString(3,etelaat.getEmail());
//        preparedStatement.setString(4,etelaat.getUser());
//        preparedStatement.setString(5 , etelaat.getPass());
//        preparedStatement.executeUpdate();
//    }
//
//    public void editePerson(String newPass,String username) throws Exception{
//        preparedStatement = connection.prepareStatement("update person values (default , ?,?,?,?,?)");
//        preparedStatement.setString(1,new name);
//        preparedStatement.setString(2,new familyname);
//        preparedStatement.setString(3,new email);
//        preparedStatement.setString(4,new uesr);
//        preparedStatement.setString(5,new pass);
//        preparedStatement.executeUpdate();
//    }
//
//    public void close() throws Exception{
//        preparedStatement.close();
//        connection.close();
//    }
//}
