import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;

public class CSV_Reader {

	public CSV_Reader() {
		//Empty constructor to initialize object
	}

	public int getFileLength(String toPath) {
		try {
			File file = new File(toPath);

			if (file.exists()) {
				FileReader fReader = new FileReader(file);
				LineNumberReader lnReader = new LineNumberReader(fReader);

				int lineNumber = 0;

				while (lnReader.readLine() != null) {
					lineNumber++;
				}
				lnReader.close();
				return lineNumber;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Course[] getCourses(String toPath) {

		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader bReader = new BufferedReader(new FileReader(toPath))) {

			Course[] scheduleValues = new Course[getFileLength(toPath)];
			int counter = 0;
			while ((line = bReader.readLine()) != null) {

				// Split on the comma
				String[] scheduleVal = line.split(cvsSplitBy);
				scheduleValues[counter] = new Course(scheduleVal[0], scheduleVal[1], scheduleVal[2], scheduleVal[3],
						Integer.parseInt(scheduleVal[4]));
				counter++;
				/***********************************************************************
				 * scheduleVal Format
				 * 
				 * professorName,daysHeld,timesHeld,roomNumber
				 * 
				 * professorName -- "John Smith" will be formatted as "Smith John" daysHeld --
				 * "Tuesday Thursday" will be "TR" and etc. timesHeld -- "11:00AM-11:50AM" will
				 * be as stated roomNumber -- integer greater than 0
				 ***********************************************************************/

			}

			return scheduleValues;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
