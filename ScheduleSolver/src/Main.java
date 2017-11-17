import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		CSV_Reader cReader = new CSV_Reader();
		String filePath = "C:/Development/GitHub/Schedule-Solver/ScheduleSolver/files/TestVal.csv";
		
		Course[] scheduleVal = cReader.getCourses(filePath);
		
		for(int i = 0; i < cReader.getFileLength(filePath); i++) {
			System.out.println(scheduleVal[i]);
		}
	}
	
}
