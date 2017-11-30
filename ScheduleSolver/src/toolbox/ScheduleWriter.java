package toolbox;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Course;

/**
 * Creates all valid possible schedules
 */
public class ScheduleWriter {

	/**
	 * Creates all valid possible schedules given Course arrays
	 * 
	 * @param courseValues
	 *            Array of Course to sort into schedules
	 */
	public static void makeScheduleFile(Course[] courseValues) throws IOException {
		Map<String, List<Course>> courseMap = new HashMap<String, List<Course>>();

		// System.out.println(Arrays.toString(courseValues));

		for (Course course : courseValues) {
			String courseTaught = course.getCourseTaught();
			List<Course> courseList = courseMap.get(courseTaught);
			if (courseList != null) {
				courseList.add(course);
			} else {
				List<Course> newCourseList = new ArrayList<Course>();
				newCourseList.add(course);
				courseMap.put(courseTaught, newCourseList);
			}
		}

		// for (Map.Entry<String, List<Course>> entry : courseMap.entrySet()) {
		// System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		// }

		ArrayList<String> courses = new ArrayList<String>(courseMap.keySet());

		// System.out.println(Arrays.toString(courses.toArray()));

		List<List<Course>> group = new ArrayList<List<Course>>();

		for (int i = 0; i < courses.size(); i++) {
			group.add(courseMap.get(courses.get(i)));
		}

		// for(List<Course> thing : group){
		// System.out.println(Arrays.toString(thing.toArray()));
		// }

		group = getAllCases(group);

		List<List<Course>> validSchedules = new ArrayList<List<Course>>();

		for (List<Course> schedule : group) {
			boolean conflict = false;
outer: 		for (int i = 0; i < schedule.size(); i++) {
				for (int j = i + 1; j < schedule.size(); j++) {
					if(CourseComparison.conflict(schedule.get(i), schedule.get(j))) {
						conflict = true;
						break outer;
					}else {
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
	 * Creates a list of all possible schedules given a list of all available times.  Each list is all possible times for a particular class.
	 * 
	 * @param totalList List of Courses with all possible times
	 * @return List of all schedules
	 */
	public static List<List<Course>> getAllCases(List<List<Course>> totalList) {
		List<List<Course>> result = new ArrayList<List<Course>>();

		for (int i = 0; i < totalList.get(0).size(); i++) {
			result.add(i, new ArrayList<Course>(Arrays.asList(totalList.get(0).get(i))));
		}

		for (int index = 1; index < totalList.size(); index++) {
			result = combineTwoLists(result, totalList.get(index));
		}

		return result;
	}

	/**
	 * Creates a new schedules for each possible time given in list2
	 * 
	 * @param list1 Current List of Schedules
	 * @param list2 Class adding into schedules
	 * @return new List of all possible schedules with new Class
	 */
	private static List<List<Course>> combineTwoLists(List<List<Course>> list1, List<Course> list2) {
		List<List<Course>> result = new ArrayList<List<Course>>();

		for (List<Course> s1 : list1) {
			for (Course s2 : list2) {
				List<Course> temp = new ArrayList<Course>(s1);
				temp.add(s2);
				result.add(temp);
			}
		}
		return result;
	}

	/**
	 * Creates .txt files for all valid possible schedules given a List<Course>
	 * 
	 * 
	 * @param file
	 *            Name of the file to create
	 * @param arrData
	 *            List that is output to the file
	 */
	private static void createFile(String file, List<Course> arrData) throws IOException {
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

}
