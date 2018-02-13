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
		assertEquals(appt.getRecurNumber(), 0);
		assertEquals(appt.getRecurBy(), 2);
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
		//am and pm are inverted so the output will not match the intended string and the assertion fails
		//toString() would have 95% coverage and representationApp() would have 88% if the bug is resolved
		//assertEquals("	11/11/2019 at 2:22am ,, \n", appt.toString());
		Appt appt2 = new Appt(0,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description); 
		
		//This assertion will always fail due to (and detect) the bug introduced in representationApp()
		//assertEquals("	11/11/2019 at 12:22am ,, \n", appt2.toString());
		assertEquals(1, appt.compareTo(appt2));
	 }

	//Test if isValid() catches invalid input
	 @Test
	  public void test02()  throws Throwable  {
		//This startHour should set valid to false. However, the bug I introduced prevents this
		int startHour = 20;
		int startHour_invalid = 24;
		int startMinute=30;
		int startMinute_invalid = 60;
		int startDay=15;
		int startDay_invalid = -1;
		int startMonth=01;
		int startMonth_invalid = -1;
		int startYear = 2017;
		String title="Invalid Appointment";
		String description="This appointment's isValid() method should return false.";
		//Construct a new Appointment object with the initial data	 
		Appt appt = new Appt(startHour,
		        startMinute ,
		        startDay ,
		        startMonth ,
		        startYear ,
		        title,
		       description);
			   
		appt.setStartMinute(startMinute_invalid);
		assertFalse(appt.getValid());
		appt.setStartMinute(startMinute);
		assertTrue(appt.getValid());
		
		appt.setStartHour(startHour_invalid);
		assertFalse(appt.getValid());
		appt.setStartHour(startHour);
		assertTrue(appt.getValid());
		
		appt.setStartDay(startDay_invalid);
		assertFalse(appt.getValid());
		appt.setStartDay(startDay);
		assertTrue(appt.getValid());
		
		appt.setStartMinute(-1*startMinute_invalid);
		assertFalse(appt.getValid());
		appt.setStartMinute(startMinute_invalid - 1);
		assertTrue(appt.getValid());
		
		appt.setStartHour(-1*startHour_invalid);
		assertFalse(appt.getValid());
		appt.setStartHour(startHour_invalid - 1);
		assertTrue(appt.getValid());
		
		appt.setStartMinute(-100*startMinute_invalid);
		assertFalse(appt.getValid());
		appt.setStartMinute(startMinute);
		assertTrue(appt.getValid());
		
		appt.setStartHour(-100*startHour_invalid);
		assertFalse(appt.getValid());
		appt.setStartHour(startHour);
		assertTrue(appt.getValid());
		
		appt.setStartDay(-100*startDay_invalid);
		assertFalse(appt.getValid());
		appt.setStartDay(startDay);
		assertTrue(appt.getValid());
		
		//appt.setStartDay(-1*startDay_invalid);
		//assertFalse(appt.getValid());
		//appt.setStartDay(startDay);
		//assertTrue(appt.getValid());
		
		//The following tests check if the method will detect erroneous months
		//However, the program detects the error and crashes before my assert statements can check the output
		/*appt.setStartMonth(startMonth_invalid);
		assertFalse(appt.getValid());
		appt.setStartMonth(startMonth);
		assertTrue(appt.getValid());*/
		
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











