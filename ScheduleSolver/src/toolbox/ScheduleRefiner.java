package toolbox;

import java.time.LocalTime;
import java.io.File;

import toolbox.ScheduleWriter;
import objects.Course;
import objects.Schedule;

/**
 * Refines the valid schedules based on what users want
 * 
 * @author Justin Krum
 */
public class ScheduleRefiner {

	public static int refineOnStart(Course course0) {
		int counter = 0;
		String toPath = "files/output/";
		int maxDirectory = CsvReader.getDirectoryLength(toPath);
		for (int i = 0; i < maxDirectory; i++) {
			Schedule scheduleValue = new Schedule(CsvReader.getCourses(toPath + "schedule" + i + ".csv"));

			if (course0.getStartTime().isAfter(scheduleValue.getFirstStartTime())) {
				(new File(toPath + "schedule" + i + ".csv")).delete();
				counter++;
			}
			System.out.println(i);
		}
		return counter;
		
	}

}
