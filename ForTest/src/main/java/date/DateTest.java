package date;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateTest {

  /**
   * @param args
   */
  @Test
  public void testDataSubstract() {
    String LastRecord = "20110316082145";
    Date ldate = getDate4(LastRecord);
    String usedate = "2011/03/16";
    String SCHE_ARR_TIME = "08:20:30";
    int arrDelaySec =
        getDateCompare(ldate,
            getDate4(usedate.replaceAll("/", "") + SCHE_ARR_TIME.replaceAll(":", "")));
    System.out.println(arrDelaySec);
    assertTrue(arrDelaySec == 75); // 有時會等於74
  }

  /**
   * 將DATE1與DATE2相減取得秒數
   * 應該還有比這個方法更適當的解法.
   */
  public int getDateCompare(Date date1, Date date2) {
    return (int) (date1.getTime() - date2.getTime()) / 1000;
  }
	
  /**
   * 將文字日期20091004235749 轉為Date物件
   */
  public Date getDate4(String SQLDate) {
    Calendar ca = Calendar.getInstance();
    ca.set(Integer.parseInt(SQLDate.substring(0, 4)),
        Integer.parseInt(SQLDate.substring(4, 6)) - 1, Integer.parseInt(SQLDate.substring(6, 8)),
        Integer.parseInt(SQLDate.substring(8, 10)), Integer.parseInt(SQLDate.substring(10, 12)),
        Integer.parseInt(SQLDate.substring(12)));

    return ca.getTime();
  }
  
  @Test
  public void testSimpleDateFormat() throws ParseException {
    String testString = "20141114";
    Date now = new Date(114, 10, 14, 00, 00, 01);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    Date when = sdf.parse(testString);
    System.out.println(now);
    System.out.println(when);
    System.out.println(now.equals(when));
  }
}
