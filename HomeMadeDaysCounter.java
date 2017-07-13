package daysCounter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Home made counter for how many days between 2 dates, excluding the end date.<br>
 * It doesn't use Java Date or Calendar or other related classes.
 *
 */
public class HomeMadeDaysCounter {
	
	private static Map<Integer, Integer> monthDaysMap = new LinkedHashMap<>();
	
	/**
	 * Count how many days between 2 dates. It excludes the end date.
     *
	 * @param start -- in yyyy/MM/dd format
	 * @param end -- in yyyy/MM/dd format
	 * @throws Exception
	 */
	public static long countDays(String start, String end) throws Exception{
		if(start.compareTo(end) > 0){
			throw new Exception("Start date is after end date.");
		}
		loadMap();
		//how many days in start year?
		int firstPartOfStartYear = getNumOfDaysFromYearBeginToDate(start);
		int daysInStartYear = 365 - firstPartOfStartYear;
		//how many days in end year?
		int daysInEndYear = getNumOfDaysFromYearBeginToDate(end);
		//how many days from the beginning of next of start year to the end of previous of end year?
		int nextYear = getYear(start) + 1;
		int previousYear = getYear(end) - 1;
		int daysDuringYears = (previousYear - nextYear + 1) * 365;
		daysDuringYears += getNumOfLeapYears(start, end);//add the offsets of leap years
		
		return daysInStartYear + daysDuringYears + daysInEndYear;
		
	}
	
	private static int getNumOfDaysFromYearBeginToDate(String date){
		int lastMonth = getMonth(date); //e.g. 1993/08/15, only needs to be on the end of July.
		int days = 0;
		for(int i = 1; i < lastMonth; i++){
			days += monthDaysMap.get(i);
		}
		int daysInThisMonth = getDay(date);
		days += daysInThisMonth - 1;//exclude the day of start date
		return days;
	}
	
	/*
	 * do not consider leap year here, because the offset of days in leap year will be considered in the end of calculation.
	 */
	private static void loadMap(){
		monthDaysMap.put(1, 31);
		monthDaysMap.put(2, 28);
		monthDaysMap.put(3, 31);
		monthDaysMap.put(4, 30);
		monthDaysMap.put(5, 31);
		monthDaysMap.put(6, 30);
		monthDaysMap.put(7, 31);
		monthDaysMap.put(8, 31);
		monthDaysMap.put(9, 30);
		monthDaysMap.put(10, 31);
		monthDaysMap.put(11, 30);
		monthDaysMap.put(12, 31);
		
	}
	
	private static int getYear(String date){
		return Integer.parseInt(date.substring(0, date.indexOf('/')));
	}
	
	private static int getMonth(String date){
		return Integer.parseInt(date.substring(date.indexOf('/') + 1, date.lastIndexOf('/')));
	}
	
	private static int getDay(String date){
		return Integer.parseInt(date.substring(date.lastIndexOf('/') + 1, date.length()));
	}
	
	private static boolean isLeapYear(int year){
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ;
	}
	
	private static int getNumOfLeapYears(String start, String end){
		int yearStart = getYear(start);
		int yearEnd = getYear(end);
		int numOfYears = yearEnd - yearStart + 1;
		int amount;
		if(isLeapYear(yearStart) || (!isLeapYear(yearStart) && isLeapYear(yearEnd))){
			Double ceil = Math.ceil(numOfYears / 4.0);
			amount = ceil.intValue();
		}else{// start and end are not leap years
			amount = numOfYears / 4;
		}
		//if start month is after February, start year won't be considered as leap year,
		//likewise, if end month is before February, end year won't be considered as leap year
		if(isLeapYear(yearStart) && getMonth(start) > 2 )
			amount -= 1;
		if(isLeapYear(yearEnd) && getMonth(end) < 2)
			amount -= 1;
		return amount;
	}
	
}
