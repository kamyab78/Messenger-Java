import java.sql.*;

public class hamzamani {
    Connection connection;
    PreparedStatement preparedStatement;
    hamzamani() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger", "postgres", "Kamyab78");
    }
    public void change1(String cloginshode) throws SQLException {
        preparedStatement = connection.prepareStatement("update login set clientlogin=?");
        preparedStatement.setString(1,cloginshode);
            preparedStatement.executeUpdate();
        }
    public void change2(String csearchshode) throws SQLException {
        preparedStatement = connection.prepareStatement("update login set clientsearch=?");
        preparedStatement.setString(1,csearchshode);
        preparedStatement.executeUpdate();
    }
    public void change3(String sloginshode) throws SQLException {
        preparedStatement = connection.prepareStatement("update login set serverlogin=?");
        preparedStatement.setString(1,sloginshode);
        preparedStatement.executeUpdate();
    }
    public void change4(String ssearchshode) throws SQLException {
        preparedStatement = connection.prepareStatement("update login set serversearch=?");
        preparedStatement.setString(1,ssearchshode);
        preparedStatement.executeUpdate();
    }
    public String getsl() throws SQLException {
        preparedStatement=connection.prepareStatement("select clientlogin from login");
//        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
resultSet.next();
        return resultSet.getString("clientlogin");
    }
    public String gets2() throws SQLException {
        preparedStatement=connection.prepareStatement("select clientsearch from login");
//        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("clientsearch");
    }
    public String gets3() throws SQLException {
        preparedStatement=connection.prepareStatement("select serverlogin from login");
//        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("serverlogin");
    }
    public String gets4() throws SQLException {
        preparedStatement=connection.prepareStatement("select serversearch from login");
//        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("serversearch");
    }
    }

