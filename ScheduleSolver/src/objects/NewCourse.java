package objects;

import java.time.LocalTime;

import toolbox.TimeManager;

/**
 * Data type for containing course information v2
 * 
 * @author Justin Krum
 */
public class NewCourse {
	
	//Initializing variables
	String professorName, timeHeld, daysHeld,
		   courseTaught, courseSection, courseTitle, courseNumber;

	int roomNumber, creditHours, 
		maxEnroll, waitEnroll, currentEnroll;
	
	double courseWeight;
	
	LocalTime startTime, endTime;

	boolean daysArray[] = new boolean[5];
	
	
	
	
	/**
	 * Constructor for Course data-type to be read from TestValMaster.csv
	 * 
	 * @param courseType The classification of the Course offered
	 * @param departmentID 3 letter identifier for a department
	 * @param courseNumber Number that denotes the specific course and syllabus for the department
	 * @param courseSection Number for the section of the course
	 * @param courseTitle Colloquial name of the course (i.e. "Analytic Geometry and Calculus 2" instead of "MAC 2312")
	 * @param courseWeight Determines the amount of effect on the GPA from this course
	 * @param lectureHours Hours this class is spent in the lecture
	 * @param labHours Hours this class is spent in the lab
	 * @param daysHeld Days that this class is held (i.e. "MWF")
	 * @param startTime Time of the day that the class starts (with AM or PM)
	 * @param endTime Time of the day that the class ends (with AM or PM)
	 * @param roomNumber Room number where the class is held
	 * @param maxEnroll Maximum number of students allowed to be enrolled into the Course
	 * @param currentEnroll Current number of students enrolled in the Course
	 * @param waitEnroll Current number of students on the wait list for the Course
	 * @param profFirstName First name of the professor teaching the Course
	 * @param profLastName Last name of the professor teaching the Course
	 */
	public NewCourse(String courseType, String departmentID, String courseNumber, String courseSection, String courseTitle, 
					 double courseWeight, int lectureHours, int labHours, String daysHeld, String startTime, String endTime, 
					 int roomNumber, int maxEnroll, int currentEnroll, int waitEnroll, String profFirstName, String profLastName) {
		
		//Sets standard variables
		this.professorName = profLastName + " " + profFirstName;
		this.courseTaught = departmentID + " " + courseNumber;	
		this.roomNumber = roomNumber;
		this.creditHours = lectureHours + labHours;
		this.courseWeight = courseWeight;
		this.courseSection = courseSection;
		this.timeHeld = startTime + "-" + endTime;
		
		//Sets enrollment variables
		this.currentEnroll = currentEnroll;
		this.maxEnroll = maxEnroll;
		this.waitEnroll = waitEnroll;
		
		// Changes standard input times to military standard times
		setStartTime(startTime);
		setEndTime(endTime);
		
		//Sets days held and boolean array of days held
		this.daysHeld = daysHeld;
		for (char c : daysHeld.toCharArray()) {
			switch (c) {
			case 'M':
				this.daysArray[0] = true;
				break;
			case 'T':
				this.daysArray[1] = true;
				break;
			case 'W':
				this.daysArray[2] = true;
				break;
			case 'R':
				this.daysArray[3] = true;
				break;
			case 'F':
				this.daysArray[4] = true;
				break;
			}
		}
	}

	
	public String toString() {
		return professorName + "," + courseTaught + "," + daysHeld + "," + timeHeld + "," + roomNumber + "," + creditHours;
	}

	/**
	 * Gets time the course starts
	 *
	 * @return start time of the course in military time
	 */
	public LocalTime getStartTime() {
		return startTime;
	}

	/**
	 * Sets time the course starts
	 *
	 * @param startTime
	 *            input of a new start time in standard time
	 */
	public void setStartTime(String startTime) {
		this.startTime = TimeManager.standardToMilitary(startTime);
	}

	/**
	 * Gets time the course ends
	 *
	 * @return end time of the course in military time
	 */
	public LocalTime getEndTime() {
		return endTime;
	}

	/**
	 * Sets time the course starts
	 *
	 * @param endTime
	 *            input of a new start time in standard time
	 */
	public void setEndTime(String endTime) {
		this.endTime = TimeManager.standardToMilitary(endTime);
	}

	/**
	 * Gets number of credit hours the course is worth
	 *
	 * @return number of credit hours
	 */
	public int getCreditHours() {
		return this.creditHours;
	}
	
	/**
	 * Sets the number of credit hours the course is worth
	 *
	 * @param creditHours
	 *            input of number of credit hours the course is worth
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Gets name of the professor teaching the course
	 *
	 * @return name of the professor
	 */
	public String getProfessorName() {
		return professorName;
	}

	/**
	 * Sets the name of the professor teaching the course
	 *
	 * @param professorName
	 *            input name of the professor teaching the course
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	/**
	 * Gets course taught
	 *
	 * @return course taught
	 */
	public String getCourseTaught() {
		return courseTaught;
	}

	/**
	 * Sets the course that is taught
	 *
	 * @param courseTaught
	 *            input of course which is taught
	 */
	public void setCourseTaught(String courseTaught) {
		this.courseTaught = courseTaught;
	}

	/**
	 * Gets boolean values of the days the course is held
	 *
	 * @return boolean array of daysHeld (i.e. "MWRF" --> "10111" as booleans)
	 */
	public boolean[] getDaysArray() {
		return this.daysArray;
	}

	/**
	 * Sets days of the week to boolean values of true or false depending on if class is that day
	 *
	 * @param daysHeld
	 *            String of days the course is held (i.e. "MWF")
	 */
	public void setdaysArray(String daysHeld) {
		//Resets all values to false before resetting to true
		for(int i = 0; i < daysArray.length; i++){
			daysArray[i] = false;
		}
		
		for (char c : daysHeld.toCharArray()) {
			switch (c) {
			case 'M':
				this.daysArray[0] = true;
				break;
			case 'T':
				this.daysArray[1] = true;
				break;
			case 'W':
				this.daysArray[2] = true;
				break;
			case 'R':
				this.daysArray[3] = true;
				break;
			case 'F':
				this.daysArray[4] = true;
				break;
			}
		}
	}

	/**
	 * Gets time the course is held
	 *
	 * @return time the course is held in standard time
	 */
	public String getTimeHeld() {
		return timeHeld;
	}

	/**
	 * Sets the time the course is held
	 *
	 * @param timeHeld
	 *            time the course is held in standard time
	 */
	public void setTimeHeld(String timeHeld) {
		startTime = TimeManager.standardToMilitary(timeHeld.substring(0, timeHeld.indexOf('-')));
		endTime = TimeManager.standardToMilitary((timeHeld.substring(timeHeld.indexOf('-') + 1)));
		this.timeHeld = timeHeld;
	}

	/**
	 * Gets room number where the course is held
	 *
	 * @return room number where course is held
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	
	/**
	 * Sets the room number where course is held
	 *
	 * @param roomNumber
	 *            room number where the course is held
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public String getDaysHeld() {
		return daysHeld;
	}


	public void setDaysHeld(String daysHeld) {
		this.daysHeld = daysHeld;
	}
}
