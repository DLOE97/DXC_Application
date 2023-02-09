
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class LoginController{

    public static boolean authenticate(User userBean) throws IOException {

            String dbUrl = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String dbUsername = "root";
            String dbPassword = "root";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                    dbUrl, dbUsername, dbPassword);

                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM login.users WHERE username = ? AND password = ?");

                statement.setString(1, userBean.getUsername());
                statement.setString(2, userBean.getPassword());

                ResultSet results = statement.executeQuery();
                boolean haveResult = results.next();
                if(haveResult){
                    userBean.setRole(results.getString("role"));
                }
                return haveResult;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Database error");
            }
            return false;
    }

}