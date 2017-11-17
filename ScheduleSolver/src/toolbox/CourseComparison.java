package toolbox;

import objects.Course;

/*
 * Ways a course conflicts with another course
 * 
 * 1. Same course taught
 * 2. Same start time and day
 * 3. Overlapping time and day
 */
public class CourseComparison {
	public static boolean conflict(Course course1, Course course2) {
		if(course1.getCourseTaught().equals(course2.getCourseTaught())) {
			return true;
		}
		
		return false;
	}
}
