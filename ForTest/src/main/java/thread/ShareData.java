package thread;


/**
 * <pre> ShareData </pre>
 *
 * @author Ian Chen
 */
public class ShareData implements Runnable {
  private int index;

  @Override
  public void run() {
    while (index < 10) {
      System.out.println(Thread.currentThread().getName() + ":" + index);
      index++;
    }
  }
}
