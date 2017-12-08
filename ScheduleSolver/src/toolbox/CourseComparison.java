package toolbox;

import java.time.LocalTime;
import objects.Course;

/*
 * Ways a course conflicts with another course
 * 
 * 1. Same course taught
 * 2. Overlapping time and day
 * 	a] Course 1 begins before and ends during Course 2
 * 	b] Course 1 starts during Course 2 and ends after Course 2
 * 	c] Course 1 starts and ends during Course 2
 */

/**
 * Conflict detection tool between two Course
 * 
 * @author Grayton Ward
 */
public class CourseComparison {

	/**
	 * Find conflicts between course0 and course1
	 * 
	 * @param course0
	 *            Base course
	 * @param course1
	 *            Course to compare to course0
	 */
	public static boolean conflict(Course course0, Course course1) {
		return (sameCourse(course0, course1) || overlapping(course0, course1));
	}

	/**
	 * Find if course0 and course1 are the same
	 * 
	 * @param course0
	 *            Base course
	 * @param course1
	 *            Course to compare to course0
	 * 
	 * @return True if courses are the same course, False otherwise
	 */
	private static boolean sameCourse(Course course0, Course course1) {
		return course0.getCourseTaught().equals(course1.getCourseTaught());
	}

	/**
	 * Find if course0 and course1 are overlapping in time/day
	 * 
	 * @param course0
	 *            Base course
	 * @param course1
	 *            Course to compare to course0
	 * 
	 * @return True if courses are overlapping, False is courses aren't overlapping
	 */
	private static boolean overlapping(Course course0, Course course1) {
		boolean overlap = false;
		LocalTime course0Start = course0.getStartTime();
		LocalTime course0End = course0.getEndTime();
		LocalTime course1Start = course1.getStartTime();
		LocalTime course1End = course1.getEndTime();
		boolean[] course0Days = course0.getDaysArray();
		boolean[] course1Days = course1.getDaysArray();

		for (int i = 0; i < course0Days.length; i++) {
			// System.out.println(i + ": " + (course0Days[i] && course1Days[i]));
			if (course0Days[i] && course1Days[i]) {
				// System.out.println(course0Start.isAfter(course1End));
				// System.out.println(course1Start.isAfter(course0End));

				if (!course0Start.isAfter(course1End) && !course1Start.isAfter(course0End)) {
					overlap = true;
					break;
				}
			}
		}
		return overlap;
	}

}
