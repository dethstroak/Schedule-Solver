package toolbox;

import java.time.LocalTime;

/**
 * All methods referring to managing or converting time
 * 
 * @author Grayton Ward
 */
public class TimeManager {

	/**
	 * Converts the standard time input into an easily comparable military time in a LocalTime Object
	 * 
	 * @param time String in format XX:XXAM / XX:XXPM
	 * @return A local time object at the input time
	 */
	public static LocalTime standardToMilitary(String time) {
		LocalTime militaryTime = LocalTime.parse("00:00");
		if (time.endsWith("PM")) {
			if (time.startsWith("12")) {
				militaryTime = LocalTime.parse(time.substring(0, time.indexOf('P')));
				return militaryTime;
			}
			militaryTime = LocalTime.parse((Integer.parseInt((time.substring(0, time.indexOf(':')))) + 12) + ":"
					+ time.substring(time.indexOf(':') + 1, time.indexOf("P")));
		} else if (time.endsWith("AM")) {
			time = time.substring(0, time.indexOf('A')); 
			if (time.length() == 4) {
				militaryTime = LocalTime.parse("0" + time);
			} else {
				militaryTime = LocalTime.parse(time);
			}

		}
		return militaryTime;
	}
}
