package toolbox;

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
public class CourseComparison {

	public static boolean conflict(Course course1, Course course2) {
		boolean returnValue = false;

		// Condition 1 -- Same course taught
		if (course1.getCourseTaught().equals(course2.getCourseTaught())) {
			return true;
		}
		// Condition 2 -- Overlapping time and day
		returnValue = conflictCondition2(course1, course2);

		return returnValue;
	}

	public static boolean conflictCondition2(Course course1, Course course2) {
		if (course1.getStartTime().equals(course2.getStartTime())) {
			// Checks if classes occur on same day, if their start times are the same
			for (int i = 0; i < course1.getDaysArray().length; i++) {
				if (course1.getDaysArray()[i] == course2.getDaysArray()[i]) {
					return true;
				}
			}
		}
		return false;
	}
}
