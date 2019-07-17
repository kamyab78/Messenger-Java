import java.sql.*;

public class tout {
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    tout() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=massanger","postgres","Kamyab78");
    }
    public void addtime(String username , String zaman) throws SQLException {
        preparedStatement=connection.prepareStatement("insert into timeout values (default ,?,?)");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,zaman);
        preparedStatement.executeUpdate();
    }
    public void tarikhoutesh(String username , String zaman) throws SQLException {
        preparedStatement=connection.prepareStatement("update timeout set zamanout=? where username=?");
   preparedStatement.setString(1,zaman);
   preparedStatement.setString(2,username);
   preparedStatement.executeUpdate();
    }
    public String seen(String username) throws SQLException {
        preparedStatement=connection.prepareStatement("select zamanout from timeout where username=?");
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("zamanout");
    }
}
