/**
 * EZTRAVEL CONFIDENTIAL
 * @Package:  date
 * @FileName: DateTest.java
 * @author:   003542
 * @date:     2022/3/21, 上午 09:06:48
 * 
 * <pre>
 *  Copyright 2013-2014 The ezTravel Co., Ltd. all rights reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of ezTravel Co., Ltd. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to ezTravel Co., Ltd. and its suppliers
 *  and may be covered by TAIWAN and Foreign Patents, patents in 
 *  process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from ezTravel Co., Ltd.
 *  </pre>
 */
package date;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
  public void tetDuration() throws ParseException {
    String testString = "20201101235959";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    Date today = sdf.parse(testString);
    // 9/16 ~ 11/30開放
    Date begin = new SimpleDateFormat("yyyy/MM/dd").parse("2020/09/16");
    Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2020/12/01");
    // 11/02 ~ 11/11關閉
    Date pauseBegin = new SimpleDateFormat("yyyy/MM/dd").parse("2020/11/02");
    Date pauseEnd = new SimpleDateFormat("yyyy/MM/dd").parse("2020/11/12");
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);

    testString = "20201102000001";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
    testString = "20201111000000";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
    testString = "20201111235959";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
    testString = "20201112000000";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
    testString = "20201130000000";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
    testString = "20201201000000";
    today = sdf.parse(testString);
    checkIsDuration(today, begin, end, pauseBegin, pauseEnd);
  }

  private void checkIsDuration(Date today, Date begin, Date end, Date pauseBegin, Date pauseEnd) {
    if (today.after(begin) && today.before(end)
        && !(today.after(pauseBegin) && today.before(pauseEnd))) {
      System.out.println(true);
    } else {
      System.out.println(false);
    }
  }
  
  /**
   * SimpleDateFormat
   */
  @Test
  public void testSimpleDateFormat() throws ParseException {
    String testString = "20141114";
    Date now = new Date(114, 10, 14, 00, 00, 00);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    Date when = sdf.parse(testString);
    System.out.println(now);
    System.out.println(when);
    System.out.println(now.equals(when)); // true
  }
  
  /**
   * 測試before就算相等也是false
   */
  @Test
  public void testBefore() throws ParseException {
    Date now1 = new Date(114, 10, 14, 00, 00, 00);
    Date now2 = new Date(114, 10, 14, 00, 00, 00);
    Date now3 = new Date(114, 10, 14, 00, 00, 01);
    System.out.println(now1);
    System.out.println(now2);
    System.out.println(now3);
    assertFalse(now1.before(now2));
    assertTrue(now1.before(now3));
  }
  
  @Test
  public void testSimpleDateFormat2() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    Date claimDt = sdf.parse("20150101130505");
    System.out.println(claimDt);
  }
  
  @Test
  public void testMinusDays() throws ParseException {
    LocalDateTime current = LocalDateTime.now();
    Date beginDate = Date.from(current.atZone(ZoneId.systemDefault()).minusDays(7).toInstant());
    System.out.println(beginDate);
  }
  
  @Test
  public void testMinusMonths() throws ParseException {
    LocalDateTime current = LocalDateTime.now();
    Date beginDate = Date.from(current.atZone(ZoneId.systemDefault()).minusMonths(11).toInstant());
    System.out.println(beginDate);
    beginDate = Date.from(current.atZone(ZoneId.systemDefault()).minusMonths(1).toInstant());
    System.out.println(beginDate);
  }
  
  @Test
  public void testDateBeforeAndAfter() throws ParseException {
    Date begin = new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/05");
    Date end = new SimpleDateFormat("yyyy/MM/dd").parse("2020/08/01");
    Date today = new Date();
    if (today.after(begin) && today.before(end)) {
      System.out.println("Pass");
    }
  }
  
  /**
   * hh:12小時制
   * HH:24小時制
   * 在00點的時候hh會變成12點.
   *
   * @throws ParseException the parse exception
   */
  @Test
  public void testDatehhVsHH() throws ParseException {
    Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse("2020/05/05 00:05");
    
    System.out.println(new SimpleDateFormat("yyyyMMddhhmm").format(date)); // 輸出12:05
    System.out.println(new SimpleDateFormat("yyyyMMddHHmm").format(date)); // 輸出00:05
  }
}
