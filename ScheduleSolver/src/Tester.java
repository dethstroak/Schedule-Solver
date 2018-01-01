
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

import gui.*;
import objects.*;
import toolbox.*;

/**
 * Tester for functionality of various classes
 */
public class Tester {

	public static Scanner in;
	
	/**
	 * Initializes global Tester values
	 */
	public static void init() {
		in = new Scanner(System.in);
	}
	
	/**
	 * Cleans up global Tester values
	 */
	public static void cleanUp() {
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

	public static void main(String[] args) {

		init();

		// testCsvReader();

		// testTimeManager();

		// testCourseComparison();

		// testScheduleWriter();

		// testScheduleObjectIntegration();

		// testScheduleRefiner();

		testScheduleMakerGui();

		// ***ONLY TEST IF SCHEDULE FILES EXIST ALREADY***
		// testScheduleTable();

		// clearScheduleFiles();

		cleanUp();

	}

	/**
	 * Tests functionality of CsvReader to import values from .csv files into
	 * arrays of usable data
	 * 
	 * @see toolbox.CsvReader
	 */
	public static void testCsvReader() {
		// Input of value for the testing
		System.out.print("Dataset: ");
		String dataSet = in.next();
		System.out.println("\n\n");

		String filePath = "files/input/" + dataSet + ".csv";

		Course[] scheduleVal = CsvReader.getCourses(filePath);

		for (int i = 0; i < CsvReader.getFileLength(filePath); i++) {
			System.out.println(scheduleVal[i]);
		}
	}

	/**
	 * Tests functionality of TimeManager
	 * @see toolbox.TimeManager
	 */
	public static void testTimeManager() {
		System.out.println(TimeManager.standardToMilitary("8:00AM"));
		System.out.println(TimeManager.standardToMilitary("10:00AM"));
		System.out.println(TimeManager.standardToMilitary("12:00PM"));
		System.out.println(TimeManager.standardToMilitary("3:00PM"));
		System.out.println(TimeManager.standardToMilitary("9:00PM"));
	}

	/**
	 * Tests functionality of CourseComparison to find if Courses conflict with
	 * one another
	 * 
	 * @see toolbox.CourseComparison
	 */
	public static void testCourseComparison() {

		Course courseA = new Course("Srinivasan Sesha", "PHY 2049", "TR", "2:30PM-3:20PM", 1049, 3);
		Course courseB = new Course("Parchamy Homaira", "IDS 2034", "T", "1:00PM-2:50PM", 1053, 3);
		System.out.println(CourseComparison.conflict(courseA, courseB));

		// ----------------------True Cases---------------------------
		// Condition 1
		Course courseC = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
		Course courseD = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
		System.out.println(CourseComparison.conflict(courseC, courseD));

		// Condition 2a
		Course courseE = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
		Course courseF = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:01AM-9:16AM", 1068, 3);
		System.out.println(CourseComparison.conflict(courseE, courseF));

		// Condition 2b
		Course courseG = new Course("Saffold Gabriel", "IDS 1038", "MW", "9:00AM-10:15AM", 1068, 3);
		Course courseH = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:00AM-9:15AM", 1068, 3);
		System.out.println(CourseComparison.conflict(courseG, courseH));

		// Condition 2c
		Course courseI = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:15AM-9:30AM", 1068, 3);
		Course courseJ = new Course("Saffold Gabriel", "IDS 1039", "MW", "8:00AM-10:00AM", 1068, 3);
		System.out.println(CourseComparison.conflict(courseI, courseJ));

		// --------------------False Cases---------------------------

		// Condition 1
		Course courseK = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
		Course courseL = new Course("Katugampola Don", "MAC 2311", "TRF", "12:30PM-1:45PM", 1044, 4);
		System.out.println(CourseComparison.conflict(courseK, courseL));

		// Condition 2
		Course courseM = new Course("Saffold Gabriel", "IDS 1038", "MW", "8:00AM-9:15AM", 1068, 3);
		Course courseN = new Course("Saffold Gabriel", "IDS 1039", "TRF", "9:00AM-10:45AM", 1068, 3);
		System.out.println(CourseComparison.conflict(courseM, courseN));
	}

	/**
	 * Tests functionality of ScheduleWriter to export values from .csv files
	 * into .txt files of valid schedules and interfacing with CsvReader,
	 * TimeManager, and CourseComparison classes
	 * 
	 * @see toolbox.ScheduleWriter
	 */
	public static void testScheduleWriter() {
		// Input of value for the testing
		System.out.print("Dataset: ");
		String dataSet = in.nextLine();
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

	/**
	 * Tests functionality of the Schedule object and all functions in the
	 * object
	 * 
	 * @see objects.Schedule
	 */
	public static void testScheduleObjectIntegration() {
		// Input of value for the testing
		System.out.print("Dataset: ");
		String dataSet = in.nextLine();
		System.out.println("\n\n");

		Schedule testSchedule = new Schedule(CsvReader.getCourses("files/input/" + dataSet + ".csv"));

		System.out.println(testSchedule.getFinalEndTime());

		System.out.println(testSchedule.getFirstStartTime());
		
		for(int i = 0; i < testSchedule.getProfessorNames().length; i++){
			System.out.println(testSchedule.getProfessorNames()[i]);
		}
		
		for(int i = 0; i < testSchedule.getDaysArray().length; i++){
			System.out.println(testSchedule.getDaysArray()[i]);
		}
		
		for(int i = 0; i < testSchedule.getDaysHeld().length; i++){
			System.out.println(testSchedule.getDaysHeld()[i]);
		}
		
		for(int i = 0; i < testSchedule.getTimesHeld().length; i++){
			System.out.println(testSchedule.getTimesHeld()[i]);
		}
		
		for(int i = 0; i < testSchedule.getCourses().length; i++){
			System.out.println(testSchedule.getCourses()[i]);
		}
	}

	/**
	 * Tests the functionality of the ScheduleRefiner
	 * @see toolbox.ScheduleRefiner
	 */
	public static void testScheduleRefiner() {
		// Creates schedule files for testing
		testScheduleWriter();

		// Sets up dummy Course value to be used as comparison
		Course dummyCourse = new Course("professorName", "XXX 0000", "", "", 0, 0);

		int tester = in.nextInt();
		int refinedSchedules = 0;
		//Earliest class functionality
		if(tester == 0){
			String testerString = in.nextLine();
			System.out.println("Earliest prefered time for class: " + testerString);

			dummyCourse.setStartTime(testerString);
			refinedSchedules = ScheduleRefiner.refineOnStart(dummyCourse);
		}
		//Latest class functionality
		else if(tester == 1){
			String testerString = in.nextLine();
			System.out.println("Latest prefered time for class: " + testerString);

			dummyCourse.setEndTime(testerString);
			refinedSchedules = ScheduleRefiner.refineOnEnd(dummyCourse);
		}

		System.out.println("Refined " + refinedSchedules + " schedules");
	}
	
	/**
	 * @see gui.ScheduleTable
	 */
	public static void testScheduleTable() {
		ScheduleTable.main(null);
	}
	
	/**
	 * @see gui.ScheduleMakerGui
	 */
	public static void testScheduleMakerGui() {
		ScheduleMakerGui.main(null);
	}
}
