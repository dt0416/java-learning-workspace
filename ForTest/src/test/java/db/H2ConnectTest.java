package db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <pre> H2ConnectTest, H2連接測試 </pre>
 *
 * @author Ian Chen
 */
public class H2ConnectTest {
  private static String driverClass = "org.h2.Driver";
  private static Connection connection;
  
  /**
   * 取得Connection
   */
  @BeforeClass
  public static void init() throws ClassNotFoundException, SQLException {
    String url = "jdbc:h2:tcp://localhost/~/test";
    String userName = "sa";
    String password = "";
    Class.forName(driverClass);

    connection = DriverManager.getConnection(url, userName, password);
    assertNotNull(connection);
  }
  
  @Test
  public void fetch() throws SQLException {
    PreparedStatement ps = connection.prepareStatement("select SYSDATE from dual");
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println(rs.getTimestamp("CURRENT_TIMESTAMP()"));
    }
    rs.close();
    ps.close();
  }
}
