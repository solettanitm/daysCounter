package daysCounter;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class HomeMadeDaysCounterTest {
	
	@Test
	public void testWithinOneMonth(){
        try {
			assertEquals(OfficialDaysCounter.countDays("2017/05/01", "2017/05/13"), HomeMadeDaysCounter.countDays("2017/05/01", "2017/05/13"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossMonthsInSameYear(){
		try {
			assertEquals(OfficialDaysCounter.countDays("2017/06/01", "2017/07/11"), HomeMadeDaysCounter.countDays("2017/06/01", "2017/07/11"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossYears(){
		try {
			//assertEquals(OfficialDaysCounter.countDays("1993/08/05", "2005/06/01"), HomeMadeDaysCounter.countDays("1993/08/05", "2005/06/01"));
			assertEquals(OfficialDaysCounter.countDays("2000/03/15", "2015/06/01"), HomeMadeDaysCounter.countDays("2000/03/15", "2015/06/01"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testCrossEars(){
		try {
			assertEquals(OfficialDaysCounter.countDays("0000/12/30", "0001/01/03"), HomeMadeDaysCounter.countDays("0000/12/30", "0001/01/03"));
		} catch (Exception e) {
			//do nothing
		}
	}
	
	@Test
	public void testLeapYear(){
		try {
			assertEquals(OfficialDaysCounter.countDays("2016/02/15", "2016/03/02"), HomeMadeDaysCounter.countDays("2016/02/15", "2016/03/02"));
		} catch (Exception e) {
			//do nothing
		}
	}
}
