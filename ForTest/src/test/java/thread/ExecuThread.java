package thread;

import org.junit.Test;

/**
 * <pre> ExecuThread, 共用資料，跑出來的結果都不同，而且單一執行緒都沒跑10次迴圈，也不一定都是5次 </pre>
 *
 * @author Ian Chen
 */
public class ExecuThread {
  
  @Test
  public void testShareData() {
    ShareData s1 = new ShareData();

    Thread t1 = new Thread(s1);
    Thread t2 = new Thread(s1);
    t1.start();
    t2.start();
  }
}
