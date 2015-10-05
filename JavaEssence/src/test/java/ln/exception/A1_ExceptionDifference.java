package ln.exception;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CheckException:一定要catch或throws
 * 通常是環境問題造成的
 * 
 * UncheckException = RuntimeException:可以不用catch或throws
 * 通常是程式bug或者不同資料造成的
 * 
 * RuntimeException也繼承Exception
 * 
 * @author Ian Chen
 */
public class A1_ExceptionDifference {

    @Test
    public void testCheckException() {
        try {
            throw new CheckException();
        } catch (CheckException e) {
            e.printStackTrace();
        }
    }
    
    @Test(expected=Exception.class)
    public void testUncheckException() {
        throw new UncheckException();
    }

}
