import java.util.Scanner;

import objects.Course;
import toolbox.CSV_Reader;
import toolbox.TimeManager;

public class Tester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choose = in.nextInt();
		
		//Tests reading from the file
		if (choose == 0) {
			CSV_Reader cReader = new CSV_Reader();
			String filePath = "files/TestVal.csv";

			Course[] scheduleVal = cReader.getCourses(filePath);

			for (int i = 0; i < cReader.getFileLength(filePath); i++) {
				System.out.println(scheduleVal[i]);
			}
		} else if (choose == 1) {
			System.out.println(TimeManager.standardToMilitary("8:00AM"));
			System.out.println(TimeManager.standardToMilitary("10:00AM"));
			System.out.println(TimeManager.standardToMilitary("12:00PM"));
			System.out.println(TimeManager.standardToMilitary("3:00PM"));
			System.out.println(TimeManager.standardToMilitary("9:00PM"));

		}

	}

}
