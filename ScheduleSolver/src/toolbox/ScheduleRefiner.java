package toolbox;

import java.time.LocalTime;
import java.io.File;

import toolbox.ScheduleWriter;
import objects.NewCourse;
import objects.Schedule;

/**
 * Refines the valid schedules based on times that the user wants
 * 
 * @author Justin Krum
 */
public class ScheduleRefiner {

	/**
	 * Eliminates schedules that start before the time specified by the user
	 * 
	 * @param course0 Only uses getStartTime(), so give a dummy NewCourse that is set for timeHeld
	 * @return number of courses eliminated
	 */
	public static int refineOnStart(NewCourse course0) {
		int counter = 0;
		String toPath = "files/output/";
		int maxDirectory = CsvReader.getDirectoryLength(toPath);
		for (int i = 0; i < maxDirectory; i++) {
			Schedule scheduleValue = new Schedule(CsvReader.getCourses(toPath + "schedule" + i + ".csv"));

			if (course0.getStartTime().isAfter(scheduleValue.getFirstStartTime())) {
				(new File(toPath + "schedule" + i + ".csv")).delete();
				counter++;
			}
		}
		return counter;

	}

	/**
	 * Eliminates schedules that end after the time specified by the user
	 * 
	 * @param course0 Only uses getEndTime(), so give a dummy NewCourse that is set for timeHeld
	 * @return 
	 */
	public static int refineOnEnd(NewCourse course0) {
		int counter = 0;
		String toPath = "files/output/";
		int maxDirectory = CsvReader.getDirectoryLength(toPath);
		for (int i = 0; i < maxDirectory; i++) {
			Schedule scheduleValue = new Schedule(CsvReader.getCourses(toPath + "schedule" + i + ".csv"));

			if (course0.getEndTime().isBefore(scheduleValue.getFinalEndTime())) {
				(new File(toPath + "schedule" + i + ".csv")).delete();
				counter++;
			}
		}
		return counter;

	}

}
