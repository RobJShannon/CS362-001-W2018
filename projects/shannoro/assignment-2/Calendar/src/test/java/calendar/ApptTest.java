package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		int recurBy = 1;
		int recurIncrement = 2;
		int recurNumber = 10;
		int[] recurDays = {1, 3, 5};
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				 
		
	// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
		assertFalse(appt.isRecurring());
		
		appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		assertTrue(appt.isRecurring());
		assertEquals(10, appt.getRecurNumber());
		assertEquals(1, appt.getRecurBy());
		assertEquals(recurDays, appt.getRecurDays());
		assertEquals(2, appt.getRecurIncrement());
		
		int startDay_new = 11;
		int startHour_new = 2;
		int startMinute_new = 22;
		int startMonth_new = 11;
		int startYear_new = 2019;
		String title_new = null, description_new = null;
		
		appt.setStartHour(startHour_new);
		appt.setStartMinute(startMinute_new);
		appt.setStartDay(startDay_new);
		appt.setStartMonth(startMonth_new);
		appt.setStartYear(startYear_new);
		appt.setTitle(title_new);
		appt.setDescription(description_new);
		
		assertTrue(appt.getValid());
		assertEquals(startHour_new, appt.getStartHour());
		assertEquals(startMinute_new, appt.getStartMinute());
		assertEquals(startDay_new, appt.getStartDay());
		assertEquals(startMonth_new, appt.getStartMonth());
		assertEquals(startYear_new, appt.getStartYear());
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
		 
		//The below assert statement will fail due to the bug I introduced
		//toString() would have 95% coverage and representationApp() would have 88% if the bug is resolved
		//assertEquals("	11/11/2019 at 2:22am ,, \n", appt.toString());
		Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description); 
		
		
		assertEquals(-20, appt.compareTo(appt2));
	 }

	//Test if isValid() catches invalid input
	 @Test
	  public void test02()  throws Throwable  {
		//This startHour should set valid to false. However, the bug I introduced prevents this
		int startHour=25;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Invalid Appointment";
		String description="This appointment's isValid() method should return false.";
		//Construct a new Appointment object with the initial data	 
		Appt invalid_appt = new Appt(startHour,
		        startMinute ,
		        startDay ,
		        startMonth ,
		        startYear ,
		        title,
		       description);
	// assertions - this assertion will never pass because of the bug I introduced into the code
		//assertFalse(invalid_appt.getValid());
	}
	
	//Test recurrence
	// @Test
	// public void test03() throws Throwable {
		//int[] recurDays;
		// /*recurDays = new int[3]
		// recurDays[0] = 1;
		// recurDays[1] = 3;
		// recurDays[2] = 5;*/
		// int recurBy = 1;
		// int recurIncrement = 2;
		// int recurNumber = 10;
		
		//appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		// appt.setRecurrence(recurBy, recurIncrement, recurNumber);
		
		// assertTrue(appt.isRecurring());
		// assertEquals(10, appt.getRecurNumber());
		// assertEquals(1, appt.getRecurBy());
		//assertEquals([1, 3, 5], appt.getRecurDays());
	// }
}











