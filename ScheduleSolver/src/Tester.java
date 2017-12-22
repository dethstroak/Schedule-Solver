
import java.io.IOException;
import java.time.LocalTime;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import objects.Course;
import objects.Schedule;
import toolbox.CsvReader;
import toolbox.ScheduleRefiner;
import toolbox.ScheduleWriter;
import toolbox.CourseComparison;
import toolbox.TimeManager;

/**
 * Tester for functionality of CsvReader, TimeManager, CourseComparison,
 * ScheduleWriter classes
 */
public class Tester {

	/**
	 * New and improved Tester.java -- Now with documentation!
	 */
	public static void main(String[] args) {

		// testCsvReader();

		// testTimeManager();

		// testCourseComparison();

		// testScheduleWriter();

		// testScheduleObjectIntegration();

		 testScheduleRefiner();

		// clearScheduleFiles();

	}

	/**
	 * Tests functionality of CsvReader to import values from .csv files into arrays
	 * of usable data
	 */
	public static void testCsvReader() {
		// Input of value for the testing
		Scanner in = new Scanner(System.in);
		System.out.print("Dataset: ");
		String dataSet = in.next();
		in.close();
		System.out.println("\n\n");

		String filePath = "files/input/" + dataSet + ".csv";

		Course[] scheduleVal = CsvReader.getCourses(filePath);

		for (int i = 0; i < CsvReader.getFileLength(filePath); i++) {
			System.out.println(scheduleVal[i]);
		}
	}

	/**
	 * Tests functionality of TimeManager to change standard time to military time
	 */
	public static void testTimeManager() {
		System.out.println(TimeManager.standardToMilitary("8:00AM"));
		System.out.println(TimeManager.standardToMilitary("10:00AM"));
		System.out.println(TimeManager.standardToMilitary("12:00PM"));
		System.out.println(TimeManager.standardToMilitary("3:00PM"));
		System.out.println(TimeManager.standardToMilitary("9:00PM"));
	}

	/**
	 * Tests functionality of CourseComparison to find if Courses conflict with one
	 * another
	 */
	public static void testCourseComparison() {

		Course course1 = new Course("Srinivasan Sesha", "PHY 2049", "TR", "2:30PM-3:20PM", 1049, 3);
		Course course2 = new Course("Parchamy Homaira", "IDS 2034", "T", "1:00PM-2:50PM", 1053, 3);
		System.out.println(CourseComparison.conflict(course1, course2));

		// ----------------------True Cases---------------------------
		// Condition 1
		// Course course1 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// Course course2 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// System.out.println(CourseComparison.conflict(course1, course2));
		//
		// // Condition 2a
		// Course course3 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// Course course4 = new Course("Saffold Gabriel", "IDS 1039",
		// "MW","8:01AM-9:16AM", 1068, 3);
		// System.out.println(CourseComparison.conflict(course3, course4));
		//
		// // Condition 2b
		// Course course5 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","9:00AM-10:15AM", 1068, 3);
		// Course course6 = new Course("Saffold Gabriel", "IDS 1039",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// System.out.println(CourseComparison.conflict(course5, course6));
		//
		// // Condition 2c
		// Course course7 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:15AM-9:30AM", 1068, 3);
		// Course course8 = new Course("Saffold Gabriel", "IDS 1039",
		// "MW","8:00AM-10:00AM", 1068, 3);
		// System.out.println(CourseComparison.conflict(course7, course8));
		//
		// // --------------------False Cases---------------------------
		//
		// // Condition 1
		// Course course9 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// Course course10 = new Course("Katugampola Don", "MAC 2311",
		// "TRF","12:30PM-1:45PM", 1044, 4);
		// System.out.println(CourseComparison.conflict(course9, course10));
		//
		// // Condition 2
		// Course course11 = new Course("Saffold Gabriel", "IDS 1038",
		// "MW","8:00AM-9:15AM", 1068, 3);
		// Course course12 = new Course("Saffold Gabriel", "IDS 1039",
		// "TRF","9:00AM-10:45AM", 1068, 3);
		// System.out.println(CourseComparison.conflict(course11, course12));
	}

	/**
	 * Tests functionality of ScheduleWriter to export values from .csv files into
	 * .txt files of valid schedules and interfacing with CsvReader, TimeManager,
	 * and CourseComparison classes
	 */
	public static void testScheduleWriter() {
		// Input of value for the testing
		Scanner in = new Scanner(System.in);
		System.out.print("Dataset: ");
		String dataSet = in.nextLine();
		in.close();
		System.out.println("\n\n");

		String filePath = "files/input/" + dataSet + ".csv";
		Course[] scheduleVal = CsvReader.getCourses(filePath);

		try {
			ScheduleWriter.makeScheduleFile(scheduleVal);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Made " + CsvReader.getDirectoryLength("files/output/") + " valid schedules");

	}

	public static void testScheduleObjectIntegration() {
		// Input of value for the testing
		Scanner in = new Scanner(System.in);
		System.out.print("Dataset: ");
		String dataSet = in.nextLine();
		in.close();
		System.out.println("\n\n");

		// Schedule testSchedule = new Schedule(CsvReader.getCourses("files/input/" +
		// dataSet + ".csv"));

		// System.out.println(testSchedule.getFinalEndTime());

		// System.out.println(testSchedule.getFirstStartTime());

		// System.out.println(Arrays.toString(testSchedule.getProfessorNames()));

		// System.out.println(Arrays.toString(testSchedule.getDaysArray()));

		// System.out.println(Arrays.toString(testSchedule.getDaysHeld()));

		// System.out.println(Arrays.toString(testSchedule.getTimesHeld()));

		// System.out.println(Arrays.toString(testSchedule.getCourses()));
	}

	public static void testScheduleRefiner() {
		//Creates schedule files for testing
		testScheduleWriter();
		
		//Sets up dummy Course value to be used as comparison
		Course dummyCourse = new Course("professorName", "XXX 0000", "", "", 0,0);
		String newStartTime = "";
		
		Scanner in = new Scanner(System.in);
		String testString = "9:00AM";
		//TODO Ho line found when Scanner is used for input? but this works
		System.out.println("Earliest prefered time for class: " + testString);
		
		dummyCourse.setStartTime(testString);
		
		System.out.println("Refined " + ScheduleRefiner.refineOnStart(dummyCourse) + " schedules");
		in.close();
	}

	/**
	 * Resets /files/output/ to a blank directory for further testing
	 */
	public static void clearScheduleFiles() {
		File directory = new File("files/output/");
		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			for (File f : files) {
				if (f.toString().contains("schedule")) {
					f.delete();
				}
			}
		}
	}

}
