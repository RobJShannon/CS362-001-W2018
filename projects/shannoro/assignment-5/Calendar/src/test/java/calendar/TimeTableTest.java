package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		//Test methods after using the default constructor
		TimeTable table = new TimeTable();
		assertNull(table.deleteAppt(null, null));
		
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="teST";
		String description="TEst";
		
		Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		Appt appt2 = new Appt(startHour + 1,
		          startMinute ,
		          startDay + 2,
		          startMonth + 3,
		          startYear ,
		          title,
		         description);
				 
		Appt appt3 = new Appt(startHour + 1,
		          startMinute ,
		          startDay + 2,
		          11,
		          2000 ,
		          title,
		         description);
				 
		Appt appt4 = new Appt(startHour + 1,
		          startMinute ,
		          startDay + 2,
		          11,
		          2000 ,
		          title,
		         description);
				 
		Appt appt5 = new Appt(startHour + 1,
		          startMinute ,
		          startDay + 2,
		          11,
		          2000 ,
		          title,
		         description);
		
		int[] recurDays = {0, 1, 2, 3};
		appt2.setRecurrence(recurDays, 2, 2, 100);
		appt1.setRecurrence(recurDays, 2, 1, 750);
		appt3.setRecurrence(recurDays, 1, 1, 10000);
		appt4.setRecurrence(recurDays, 2, 1, 10000);
		appt5.setRecurrence(recurDays, 3, 1, 10000);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt1);
		appts.add(appt2);
		int[] permutation = {1, 0};
		int[] error_permutation = {0};
		
		assertTrue(table.permute(appts, permutation).size() == 2);
		//Tests to make sure the proper exception is thrown from the sizing mismatch
		//assertNull(table.permute(appts, error_permutation));
		
		GregorianCalendar day1 = new GregorianCalendar(2017, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2017, 5, 5);
		appts.add(appt3);
		appts.add(appt4);
		appts.add(appt5);
		
		assertFalse(table.getApptRange(appts, day1, day2) == null);
		//Tests to make sure the method raises an exception when the dates are in the wrong order
		//The bug I introduced will actually allow this and raise an exception on a correct input instead
		//assertNull(table.getApptRange(appts, day2, day1));
		
		assertFalse(table.deleteAppt(appts, appt1) == null);
		assertNull(table.deleteAppt(appts, appt1));
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
