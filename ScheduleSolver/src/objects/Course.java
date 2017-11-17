package objects;
import java.time.LocalTime;

import toolbox.TimeManager;

public class Course {
	
	String professorName = "",
		   courseTaught = "",
		   timeHeld = "",
		   daysHeld = "";
	
	int roomNumber = -1,
		creditHours = 0;
	
	LocalTime startTime;
	LocalTime endTime;
	
	boolean daysArray[] = new boolean[5]; 
	
	public Course(String professorName, String courseTaught, String daysHeld, String timeHeld, int roomNumber, int creditHours) {
		this.professorName = professorName.replaceAll(" ", ",");
		this.courseTaught = courseTaught;
		
		startTime = TimeManager.standardToMilitary(timeHeld.substring(0, timeHeld.indexOf('-')));
		endTime = TimeManager.standardToMilitary((timeHeld.substring(timeHeld.indexOf('-')+1)));
		
		this.roomNumber = roomNumber;
		this.creditHours = creditHours;
		this.daysHeld = daysHeld;
		
		for(char c:daysHeld.toCharArray()) {
			switch(c) {
			case 'M':
				this.daysArray[0]=true;
				break;
			case 'T':
				this.daysArray[1]=true;
				break;
			case 'W':
				this.daysArray[2]=true;
				break;
			case 'R':
				this.daysArray[3]=true;
				break;
			case 'F':
				this.daysArray[4]=true;
				break;
			}
		}
	}
	
	public String toString() {
		return professorName + " -- " + daysHeld + " -- " + startTime + "-" + endTime + " -- " + roomNumber + "-- " + creditHours;
	}
	
	public int getCreditHours() {
		return this.creditHours;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	public String getProfessorName() {
		return professorName;
	}

	public String getCourseTaught() {
		return courseTaught;
	}

	public void setCourseTaught(String courseTaught) {
		this.courseTaught = courseTaught;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	
	public boolean[] getdaysArray() {
		return this.daysArray;
	}
	
	public void setdaysArray(String daysHeld) {
		for(char c:daysHeld.toCharArray()) {
			switch(c) {
			case 'M':
				this.daysArray[0]=true;
				break;
			case 'T':
				this.daysArray[1]=true;
				break;
			case 'W':
				this.daysArray[2]=true;
				break;
			case 'R':
				this.daysArray[3]=true;
				break;
			case 'F':
				this.daysArray[4]=true;
				break;
			}
		}
	}

	public String getTimeHeld() {
		return timeHeld;
	}

	public void setTimeHeld(String timeHeld) {
		this.timeHeld = timeHeld;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
