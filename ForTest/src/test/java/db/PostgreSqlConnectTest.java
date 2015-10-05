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
 * <pre> PostgreSqlConnectTest, PostgreSQL連接測試 </pre>
 *
 * @author Ian Chen
 */
public class PostgreSqlConnectTest {
  private static String driverClass = "org.postgresql.Driver";
  private static Connection connection;
  
  /**
   * 取得Connection
   */
  @BeforeClass
  public static void init() throws ClassNotFoundException, SQLException {
    String url = "jdbc:postgresql://10.10.2.68:5444/ezfrnplatform";
    String userName = "ian";
    String password = "ez_12345";
    Class.forName(driverClass);

    connection = DriverManager.getConnection(url, userName, password);
    assertNotNull(connection);
  }
  
  @Test
  public void fetch() throws SQLException {
    PreparedStatement ps = connection.prepareStatement("select SYSDATE");
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println(rs.getTimestamp("SYSDATE"));
    }
    rs.close();
    ps.close();
  }
  
  @Test
  public void fetchTable() throws SQLException {
    PreparedStatement ps = connection.prepareStatement("select pf_prod_no from tblpfpro limit 10");
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      System.out.println(rs.getString("pf_prod_no"));
    }
    rs.close();
    ps.close();
  }
}
