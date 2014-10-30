package ln.concurrent;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * <pre>
 * 使用Callable及FutureTask達到thread也可回傳值
 * FutureTask像是proxy，利用他來取得回傳值
 * </pre>
 *
 * @author Ian Chen
 */
public class A1_CallableTest {
  private static final Logger logger = Logger.getLogger(Class.class);

  @Test
  public void test() {
    Callable<String> helloCallable = new HelloCallable("Bill");
    FutureTask<String> helloTask = new FutureTask<String>(helloCallable);

    Thread thread = new Thread(helloTask);
    thread.start();
    try {
      Thread.sleep(1000);
      if(helloTask.isDone()) {
        String hello = helloTask.get();
        logger.info(hello);
        assertThat(hello, is(equalTo("Hello Bill!!")));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
