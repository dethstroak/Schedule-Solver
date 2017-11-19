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
			System.out.println("Condition 1");
			return true;
		}
		// Condition 2 -- Overlapping time and day
		for(int i = 0; i < 5; i++) {
			if(course1.getDaysArray()[i] = course2.getDaysArray()[i]) {
				//Condition 2a
				if(course1.getStartTime().isBefore(course2.getStartTime()) && course2.getEndTime().isAfter(course1.getEndTime()) ||
				   course2.getStartTime().isBefore(course1.getStartTime()) && course1.getEndTime().isAfter(course2.getEndTime())) {
					System.out.println("Condition 2a");
					return true;
				}
				//Condition 2b
				else if(course1.getStartTime().isAfter(course2.getStartTime()) && course2.getEndTime().isBefore(course1.getEndTime()) ||
						course2.getStartTime().isAfter(course1.getStartTime()) && course1.getEndTime().isBefore(course2.getEndTime())) {
					System.out.println("Condition 2b");
					return true;
				}
				//Condition 2c
				else if(course1.getStartTime().isAfter(course2.getStartTime()) && course2.getEndTime().isAfter(course1.getEndTime()) ||
						course2.getStartTime().isAfter(course1.getStartTime()) && course1.getEndTime().isAfter(course2.getEndTime())) {
					System.out.println("Condition 2c");
					return true;
				}
			}
		}
		

		return returnValue;
	}
}
