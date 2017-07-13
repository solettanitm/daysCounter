package daysCounter;

import static org.junit.Assert.*;

import org.junit.Test;

public class OfficialDaysCounterTest {

	@Test
	public void testWithinOneMonth(){
        try {
			assertEquals(12L, OfficialDaysCounter.countDays("2017/05/01", "2017/05/13"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossMonths(){
		try {
			assertEquals(59L, OfficialDaysCounter.countDays("2017/05/13", "2017/07/11"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossYears(){
		try {
			assertEquals(33L, OfficialDaysCounter.countDays("2016/11/30", "2017/01/02"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossEars(){
		try {
			assertEquals(4L, OfficialDaysCounter.countDays("0000/12/30", "0001/01/03"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testLeapYear(){
		try {
			assertEquals(16L, OfficialDaysCounter.countDays("2016/02/15", "2016/03/02"));
		} catch (Exception e) {
			//do nothing
		}
	}
}
