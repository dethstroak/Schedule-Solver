package toolbox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.NewCourse;
import objects.NewCourse;

/**
 * All methods that pertain to writing information duting File IO
 * 
 * @author Grayton Ward and Justin Krum
 */
public class ScheduleWriter {

	/**
	 * Creates all valid possible schedules given NewCourse arrays
	 * 
	 * @param courseValues
	 *            Array of NewCourse to sort into schedules
	 * 
	 * @author Grayton Ward
	 */
	public static void makeScheduleFile(NewCourse[] courseValues) throws IOException {
		Map<String, List<NewCourse>> courseMap = new HashMap<String, List<NewCourse>>();

		// System.out.println(Arrays.toString(courseValues));

		for (NewCourse course : courseValues) {
			String courseTaught = course.getCourseTaught();
			List<NewCourse> courseList = courseMap.get(courseTaught);
			if (courseList != null) {
				courseList.add(course);
			} else {
				List<NewCourse> newCourseList = new ArrayList<NewCourse>();
				newCourseList.add(course);
				courseMap.put(courseTaught, newCourseList);
			}
		}

		// for (Map.Entry<String, List<NewCourse>> entry : courseMap.entrySet()) {
		// System.out.println(entry.getKey() + ":" +
		// entry.getValue().toString());
		// }

		ArrayList<String> courses = new ArrayList<String>(courseMap.keySet());

		// System.out.println(Arrays.toString(courses.toArray()));

		List<List<NewCourse>> group = new ArrayList<List<NewCourse>>();

		for (int i = 0; i < courses.size(); i++) {
			group.add(courseMap.get(courses.get(i)));
		}

		// for(List<NewCourse> thing : group){
		// System.out.println(Arrays.toString(thing.toArray()));
		// }

		group = getAllCases(group);

		List<List<NewCourse>> validSchedules = new ArrayList<List<NewCourse>>();

		for (List<NewCourse> schedule : group) {
			boolean conflict = false;
			outer: for (int i = 0; i < schedule.size(); i++) {
				for (int j = i + 1; j < schedule.size(); j++) {
					if (CourseComparison.conflict(schedule.get(i), schedule.get(j))) {
						conflict = true;
						break outer;
					} else {
						conflict = false;
					}
				}
			}
			if (!conflict) {
				validSchedules.add(schedule);
			}
		}

		for (int i = 0; i < validSchedules.size(); i++) {
			createFile("schedule" + i, validSchedules.get(i));
		}
	}

	/**
	 * Creates a list of all possible schedules given a list of all available
	 * times. Each list is all possible times for a particular class.
	 * 
	 * @param totalList
	 *            List of Courses with all possible times
	 * @return List of all schedules
	 * 
	 * @author Grayton Ward
	 */
	public static List<List<NewCourse>> getAllCases(List<List<NewCourse>> totalList) {
		List<List<NewCourse>> result = new ArrayList<List<NewCourse>>();

		for (int i = 0; i < totalList.get(0).size(); i++) {
			result.add(i, new ArrayList<NewCourse>(Arrays.asList(totalList.get(0).get(i))));
		}

		for (int index = 1; index < totalList.size(); index++) {
			result = combineTwoLists(result, totalList.get(index));
		}

		return result;
	}

	/**
	 * Creates a new schedules for each possible time given in list2
	 * 
	 * @param list1
	 *            Current List of Schedules
	 * @param list2
	 *            Class adding into schedules
	 * @return new List of all possible schedules with new NewCourse
	 * 
	 * @author Grayton Ward
	 */
	private static List<List<NewCourse>> combineTwoLists(List<List<NewCourse>> list1, List<NewCourse> list2) {
		List<List<NewCourse>> result = new ArrayList<List<NewCourse>>();

		for (List<NewCourse> s1 : list1) {
			for (NewCourse s2 : list2) {
				List<NewCourse> temp = new ArrayList<NewCourse>(s1);
				temp.add(s2);
				result.add(temp);
			}
		}
		return result;
	}

	/**
	 * Creates .txt files for all valid possible schedules given a List<NewCourse>
	 * 
	 * 
	 * @param file
	 *            Name of the file to create
	 * @param arrData
	 *            List that is output to the file
	 * 
	 * @author Justin Krum
	 */
	private static void createFile(String file, List<NewCourse> arrData) throws IOException {
		// File fileTemp = new File()
		FileWriter writer = new FileWriter("files/output/" + file + ".csv");
		int size = arrData.size();
		for (int i = 0; i < size; i++) {
			String str = arrData.get(i).toString();
			writer.write(str);
			if (i < size - 1)// This prevent creating a blank like at the end of the file
				writer.write("\n");
		}
		writer.close();
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
	
	/**
	 * Give it a file of NewCourse to compare to and String of the courseTaught codes you need, and it will poop out an array of
	 * compatible NewCourse variables
	 * 
	 * @param coursesNeeded String array of the names of the courses needed by the user
	 * @param toPath Path of the file that these course names are in
	 * @return NewCourse array to be sent to makeScheduleFile
	 * 
	 * @author Justin Krum
	 */
	public static NewCourse[] compileSchedule(String toPath, String[] coursesNeeded) {
		List<NewCourse> compiledSchedule = new ArrayList<NewCourse>();
		
		//TODO decide which of the overloaded functions to use
		NewCourse[] avaliableCourses = CsvReader.getCourses(toPath);
		for(String name : coursesNeeded) {
			for(int i = 0; i < avaliableCourses.length; i++) {
				if(name.toUpperCase().equals(avaliableCourses[i].getCourseTaught().toUpperCase())) {
					compiledSchedule.add(avaliableCourses[i]);
				}
			}
		}
		
		NewCourse[] compiledScheduleArray = new NewCourse[compiledSchedule.size()];
		for(int i = 0; i < compiledSchedule.size(); i++) {
			compiledScheduleArray[i] = compiledSchedule.get(i);
		}
		
		return compiledScheduleArray;
	}

}
