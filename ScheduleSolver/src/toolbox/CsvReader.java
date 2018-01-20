package toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import objects.Course;

/**
 * All methods pertaining to reading information during File IO
 * 
 * @author Justin Krum
 */
public class CsvReader {

	public static int getDirectoryLength(String toPath) {
		File directory = new File("files/output/");
		if (directory.isDirectory()) {
			return directory.listFiles().length;
		} else
			return -1;
	}

	/**
	 * Gets the length of the file in order to correctly output data within the file
	 *
	 * @param toPath
	 *            Path to find the .csv file specified by the user
	 * 
	 * @return Length of the file, in terms of how many lines the file is long
	 */
	public static int getFileLength(String toPath) {
		try {
			File file = new File(toPath);

			if (file.exists()) {
				FileReader fReader = new FileReader(file);
				LineNumberReader lnReader = new LineNumberReader(fReader);

				// Counter for line number
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
		// Returns -1 if the file does not exist
		return -1;
	}

	/**
	 * Gets the length of the file in order to correctly output data within the file
	 * 
	 * @param inputFile
	 *            File object pointing to input file
	 * @return Length of the file, in terms of how many lines the file is long
	 */

	public static int getFileLength(File inputFile) {
		try {
			File file = inputFile;

			if (file.exists()) {
				FileReader fReader = new FileReader(file);
				LineNumberReader lnReader = new LineNumberReader(fReader);

				// Counter for line number
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
		// Returns -1 if the file does not exist
		return -1;
	}

	/**
	 * Gets a Course array from a path for a .csv file specified by the user
	 *
	 * @param toPath
	 *            Path to find the .csv file specified by the user
	 * 
	 * @return An array of Course data for the user to manipulate as needed
	 */
	public static Course[] getCourses(String toPath) {

		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader bReader = new BufferedReader(new FileReader(toPath))) {

			Course[] scheduleValues = new Course[getFileLength(toPath)];
			int counter = 0;
			while ((line = bReader.readLine()) != null) {

				// Split on the comma
				String[] scheduleVal = line.split(cvsSplitBy);
				scheduleValues[counter] = new Course(scheduleVal[0], // professorName
						scheduleVal[1], // courseTaught
						scheduleVal[2], // daysHeld
						scheduleVal[3], // timesHeld
						Integer.parseInt(scheduleVal[4]), // roomNumber
						Integer.parseInt(scheduleVal[5])); // creditHours
				counter++;

			}

			return scheduleValues;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets a Course array from a path for a .csv file specified by the user
	 *
	 * @param inputFile
	 *            File object pointing to the .csv file specified by the user
	 * 
	 * @return An array of Course data for the user to manipulate as needed
	 */
	public static Course[] getCourses(File inputFile) {

		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader bReader = new BufferedReader(new FileReader(inputFile))) {

			Course[] scheduleValues = new Course[getFileLength(inputFile)];
			int counter = 0;
			while ((line = bReader.readLine()) != null) {

				// Split on the comma
				String[] scheduleVal = line.split(cvsSplitBy);
				scheduleValues[counter] = new Course(scheduleVal[0], // professorName
						scheduleVal[1], // courseTaught
						scheduleVal[2], // daysHeld
						scheduleVal[3], // timesHeld
						Integer.parseInt(scheduleVal[4]), // roomNumber
						Integer.parseInt(scheduleVal[5])); // creditHours
				counter++;

			}

			return scheduleValues;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
