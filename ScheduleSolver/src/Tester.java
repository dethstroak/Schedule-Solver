import java.util.Scanner;

import objects.Course;
import toolbox.CsvReader;
import toolbox.TimeManager;
import toolbox.CourseComparison;

public class Tester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choose = in.nextInt();
		
		//Tests reading from the file
		if (choose == 0) {
			String filePath = "files/TestVal.csv";

			Course[] scheduleVal = CsvReader.getCourses(filePath);

			for (int i = 0; i < CsvReader.getFileLength(filePath); i++) {
				System.out.println(scheduleVal[i]);
			}			
		}
		//Tests standard to military time
		else if (choose == 1) {
			System.out.println(TimeManager.standardToMilitary("8:00AM"));
			System.out.println(TimeManager.standardToMilitary("10:00AM"));
			System.out.println(TimeManager.standardToMilitary("12:00PM"));
			System.out.println(TimeManager.standardToMilitary("3:00PM"));
			System.out.println(TimeManager.standardToMilitary("9:00PM"));
		}
		//Tests Class Conflict Cases for True
		else if(choose == 2) {
			
			//String professorName, String courseTaught, String daysHeld, String timeHeld, int roomNumber, int creditHours
			
			//Condition 1
			Course course1 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
			Course course2 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
			System.out.println(CourseComparison.conflict(course1, course2));
			
			//Condition 2a
			Course course3 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
			Course course4 = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:01AM-9:16AM", 1068, 3);
			System.out.println(CourseComparison.conflict(course3, course4));
			
			//Condition 2b
			Course course5 = new Course("Saffold Gabriel", "IDS 1038", "MW", "9:00AM-10:15AM", 1068, 3);
			Course course6 = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:00AM-9:15AM", 1068, 3);
			System.out.println(CourseComparison.conflict(course5, course6));
			
			//Condition 2c
			Course course7 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:15AM-9:30AM", 1068, 3);
			Course course8 = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:00AM-10:00AM", 1068, 3);
			System.out.println(CourseComparison.conflict(course7, course8));
		}
		
		//Tests Class Conflict Cases for False
				else if(choose == 3) {
					
					//String professorName, String courseTaught, String daysHeld, String timeHeld, int roomNumber, int creditHours
					
					//Condition 1
					Course course1 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
					Course course2 = new Course("Katugampola Don", "MAC 2311", "TRF", "12:30PM-1:45PM", 1044, 4);
					System.out.println(CourseComparison.conflict(course1, course2));
					
					//Condition 2
					Course course3 = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
					Course course4 = new Course("Saffold Gabriel", "IDS 1039", "MW", "9:30AM-10:45AM", 1068, 3);
					System.out.println(CourseComparison.conflict(course3, course4));
				}
	}

}
