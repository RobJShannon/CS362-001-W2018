package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
	
	

	 @Test
	  public void test01()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());
		assertNull(day.iterator());
		assertEquals("", day.toString());
		
	 }
	 @Test
	  public void test02()  throws Throwable  {
		
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title=null;
		String description=null;
		
		Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		Appt appt2 = new Appt(startHour + 1,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		Appt appt3 = new Appt(startHour - 1,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		  
		  
		GregorianCalendar cal = new GregorianCalendar(); 
		CalDay day = new CalDay(cal);
		assertTrue(day.isValid());
		assertEquals(cal.get(cal.DAY_OF_MONTH), day.getDay());
		assertEquals(cal.get(cal.MONTH), day.getMonth());
		assertEquals(cal.get(cal.YEAR), day.getYear());
		assertTrue(day.getAppts().isEmpty());
		assertEquals(0, day.getSizeAppts());
		
		day.addAppt(appt1);
		day.addAppt(appt2);
		day.addAppt(appt3);
		
		assertFalse(day.toString() == "");
		assertFalse(day.iterator() == null);
		
		//CalDay day2 = new CalDay(null);
	 }
//add more unit tests as you needed	
}
