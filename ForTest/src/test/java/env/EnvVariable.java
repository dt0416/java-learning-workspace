package env;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <pre> EnvVariable, 測試環境變數 </pre>
 *
 * @author Ian Chen
 */
public class EnvVariable {

  @Test
  public void testGetEnvVariable() {
    String location = System.getenv("FRNPLATFORM_CONF");
    System.out.println(location);
    assertNotNull(location);
  }
}
