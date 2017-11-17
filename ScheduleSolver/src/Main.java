import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		CSV_Reader cReader = new CSV_Reader();
		String filePath = "C:/Development/Java/Workspace/ScheduleSolver/files/TestVal.txt";
		
		Course[] scheduleVal = cReader.getCourses(filePath);
		
		for(int i = 0; i < cReader.getFileLength(filePath); i++) {
			System.out.println(scheduleVal[i]);
		}
	}
	
}
