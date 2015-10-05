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
 * <pre> OracleConnectTest, Oracle連接測試 </pre>
 *
 * @author Ian Chen
 */
public class OracleConnectTest {
  private static String driverClass = "oracle.jdbc.OracleDriver";
  private static Connection connection;
  long startTime = System.currentTimeMillis();

  /**
   * 取得Connection
   */
  @BeforeClass
  public static void init() throws ClassNotFoundException, SQLException {
    String url = "jdbc:oracle:thin:@v890-3.eztravel.com.tw:1521:erpdbhtl";
    String userName = "itian";
    String password = "ezbeta_151001";
    Class.forName(driverClass);

    connection = DriverManager.getConnection(url, userName, password);
    assertNotNull(connection);
  }
  
  @Test
  public void fetch() throws SQLException {
    PreparedStatement ps = connection.prepareStatement("select SYSDATE from dual");
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println(rs.getTimestamp("SYSDATE"));
    }
    rs.close();
    ps.close();
    System.out.println("performance(" + (System.currentTimeMillis() - startTime) + "ms)");
  }

}
