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
public class CourseComparison {

	public static boolean conflict(Course course0, Course course1) {
		return (sameCourse(course0, course1) || overlapping(course0, course1));
	}
	
	private static boolean sameCourse(Course course0, Course course1) {
		return course0.getCourseTaught().equals(course1.getCourseTaught());
	}
	
	private static boolean overlapping(Course course0, Course course1) {
		boolean overlapp =false;
		LocalTime course0Start = course0.getStartTime();
		LocalTime course0End = course0.getEndTime();
		LocalTime course1Start = course1.getStartTime();
		LocalTime course1End = course1.getEndTime();
		boolean[] course0Days = course0.getDaysArray();
		boolean[] course1Days = course1.getDaysArray();
		
		for(int i=0; i<course0Days.length; i++) {
			if(course0Days[i] && course1Days[i]) {
				if(!course0Start.isAfter(course1End) && !course1Start.isAfter(course0End)) {
					overlapp = true;
					break;
				}
			}
		}
		return overlapp;
	}
	
}
