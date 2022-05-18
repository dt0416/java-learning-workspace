package date;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarTest {

  @Test
  public void test() throws ParseException {
    String saleDt = "20140925";
    Calendar cal = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    cal.setTime(dateFormat.parse(saleDt));
    String fullSaleDt =
        cal.get(Calendar.YEAR) + " / " + (cal.get(Calendar.MONTH) + 1) + " / "
            + cal.get(Calendar.DATE) + " (" + calendarDayOfWeekToTaiwanDay(cal.get(Calendar.DAY_OF_WEEK)) + ")";
    cal.get(Calendar.HOUR);
    System.out.println(fullSaleDt); // 2014 / 9 / 25 (四)
  }

  private String calendarDayOfWeekToTaiwanDay(int dayOfWeek) {
    final String[] week = {"日", "一", "二", "三", "四", "五", "六"};
    return week[dayOfWeek - 1];
  }
  
  @Test
  public void testAdd() throws ParseException {
    Calendar cal = Calendar.getInstance();
    System.out.println(new Date());
    cal.add(Calendar.DAY_OF_YEAR, 20);
    System.out.println(cal.getTime());
  }
  
  @Test
  public void testCalToStr() {
    Date date = Calendar.getInstance().getTime();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
    System.out.println(df.format(date));
  }
  
  @Test
  public void test0點() {
    Calendar c = Calendar.getInstance();
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    Date date = c.getTime();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
    System.out.println(df.format(date));
  }
  
  @Test
  public void test3年前的0101() {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.YEAR, -3);
    c.set(Calendar.MONTH, 0);
    c.set(Calendar.DAY_OF_MONTH, 1);
    Date date = c.getTime();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
    System.out.println(df.format(date));
  }
  
  @Test
  public void test11個月和1個月() {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.MONTH, -11);
    Date date = c.getTime();
    DateFormat df = new SimpleDateFormat("yyyyMM");
    System.out.println(df.format(date));
    c = Calendar.getInstance();
    c.add(Calendar.MONTH, -1);
    date = c.getTime();
    System.out.println(df.format(date));
  }
}
