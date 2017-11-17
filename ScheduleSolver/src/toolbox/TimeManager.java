package toolbox;

import java.time.LocalTime;

public class TimeManager {
	public static LocalTime standardToMilitary(String time) {
		LocalTime militaryTime = LocalTime.parse("00:00");
		if (time.endsWith("PM")) { // If afternoon
			if (time.startsWith("12")) { // Exception for 12 pm times
				militaryTime = LocalTime.parse(time.substring(0, time.indexOf('P'))); // Directly parse time
				return militaryTime; // Return parsed time
			} // Take the format of XX:XXPM Take the first two numbers and add 12 to it Add
				// the Colon Add the minutes
			militaryTime = LocalTime.parse((Integer.parseInt((time.substring(0, time.indexOf(':')))) + 12) + ":"
					+ time.substring(time.indexOf(':') + 1, time.indexOf("P")));
		} else if (time.endsWith("AM")) { // If morning
			time = time.substring(0, time.indexOf('A')); // Get the raw time without AM
			if (time.length() == 4) { // If the string does not have enought digits like 8:00
				militaryTime = LocalTime.parse("0" + time); // Add on an extra 0 to the parse to make 08:00
			} else { // Otherwise
				militaryTime = LocalTime.parse(time); // Parse the Time
			}

		}
		return militaryTime; // Return the modified time as LocalTime Object
	}
}
