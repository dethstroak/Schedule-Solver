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
	
	public static boolean refineValidSchedules(Course course0) {
		Course conflictCourse = new Course("blankName", "XXX 0000", course0.getDaysHeld(), 
											course0.getTimeHeld(), 0, 0);
		boolean deletedInvalidSchedules = false;
		
		for(int i = 0; i < CsvReader.getDirectoryLength("files/output/"); i++) {
			//TODO giving NullPointerException and FileNotFoundException??
			Schedule scheduleValue = new Schedule(CsvReader.getCourses("/files/output/schedule" + i + ".csv"));
			for(int j = 0; j < scheduleValue.getCourses().length; j++) {
				if(CourseComparison.conflict(scheduleValue.getCourses()[j], conflictCourse)) {
					deletedInvalidSchedules = (new File("/files/output.schedule" + i + ".csv").delete());
				}
			}
		}
		
		return deletedInvalidSchedules;
		
	}
	
}
