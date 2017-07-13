package daysCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * The class which uses built-in LocalDate class to get number of days. (Java version is 8)<br>
 * It is used for verifying my home-made day counter.
 *
 */
public class OfficialDaysCounter {

	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	/**
	 * Count how many days between 2 dates. It excludes the end date.
     *
	 * @param start -- in yyyy/MM/dd format
	 * @param end -- in yyyy/MM/dd format
	 * @throws Exception
	 */
	public static long countDays(String start, String end) throws Exception{
		LocalDate startDate = LocalDate.parse(start, DF);
		LocalDate endDate = LocalDate.parse(end, DF);
		return ChronoUnit.DAYS.between(startDate, endDate);
	}
	
}
