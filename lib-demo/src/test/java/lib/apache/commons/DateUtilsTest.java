package lib.apache.commons;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

/**
 * @author Ian Chen
 *
 */
public class DateUtilsTest {

	@Test
	public void test() throws ParseException {
		System.out.println(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		System.out.println(dateWithoutTime);
	}

}
