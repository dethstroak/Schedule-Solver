package toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import objects.Course;
import objects.NewCourse;

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
	public static NewCourse[] getCourses(String toPath) {

		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader bReader = new BufferedReader(new FileReader(toPath))) {

			NewCourse[] scheduleValues = new NewCourse[getFileLength(toPath)];
			int counter = 0;
			while ((line = bReader.readLine()) != null) {
				
				/*
				Course Type,Department,Course,Section,Course Name,Credits,Course Weight,Lecture Hours,Lab Hours,Offer Days,
				Offer Time From
				Offer Time To,Room Number,Maximum Enroll,Current Enroll,Wait Enrollment,Faculty First Name,Faculty Last Name
				
				*/
				
				// Split on the comma
				String[] lineSplit = line.split(cvsSplitBy);
				scheduleValues[counter] = new NewCourse(
						lineSplit[0], //courseType
						lineSplit[1], //departmentID
						lineSplit[2], //courseTaught
						lineSplit[3], //courseSection
						lineSplit[4], //courseName
						Double.parseDouble(lineSplit[6]), //courseWeight
						Integer.parseInt(lineSplit[7]), //lectureHours
						Integer.parseInt(lineSplit[8]), //labHours
						lineSplit[9], //offerDays
						lineSplit[10], //startTime
						lineSplit[11], //endTime
						Integer.parseInt(lineSplit[12]), //roomNumber
						Integer.parseInt(lineSplit[13]), //maximumEnroll
						Integer.parseInt(lineSplit[14]), //currentEnroll
						Integer.parseInt(lineSplit[15]), //waitEnroll
						lineSplit[16], //profFirstName
						lineSplit[17]  //profLastName
						);
				counter++;

			}

			return scheduleValues;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
