package com.date;

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
    System.out.println(fullSaleDt);
  }

  private String calendarDayOfWeekToTaiwanDay(int dayOfWeek) {
    final String[] week = {"日", "一", "二", "三", "四", "五", "六"};
    return week[dayOfWeek - 1];
  }
  
  @Test
  public void testAdd() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 20);
    System.out.println(cal.getTime());
  }
}
