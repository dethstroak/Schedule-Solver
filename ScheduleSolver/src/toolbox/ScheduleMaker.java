package toolbox;

import toolbox.CourseComparison;
import objects.Course;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScheduleMaker {
	
	public static void makeScheduleFile(Course[] courseValues) {
		for(int i = 0; i < courseValues.length; i++) {
			ArrayList<Course> courseList = new ArrayList<Course>();
				boolean conflict = false;
				for(int k = 0; k < courseValues.length; k++) {
					conflict = CourseComparison.conflict(courseValues[i], courseValues[k]);
				}
				
				if(!conflict) {
					courseList.add(courseValues[i]);
				}
			//Outputs the schedule to a .txt file
			try {
				createFile(("Schedule" + i), courseList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void createFile(String file, ArrayList<Course> arrData) throws IOException {
		
        FileWriter writer = new FileWriter("files/output/" + file + ".txt");
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file
                writer.write("\n");
        }
        writer.close();
    }
	
}
