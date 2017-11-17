
public class Course {
	
	String professorName = "",
			courseTaught = "",
			timeHeld = "";
	int roomNumber = -1;
	boolean daysHeld[] = new boolean[5]; 
	
	public Course(String professorName, String courseTaught, String daysHeld, String timeHeld, int roomNumber) {
		this.professorName = professorName;
		this.courseTaught = courseTaught;
		this.timeHeld = timeHeld;
		this.roomNumber = roomNumber;
		
		for(char c:daysHeld.toCharArray()) {
			switch(c) {
			case 'M':
				this.daysHeld[0]=true;
				break;
			case 'T':
				this.daysHeld[1]=true;
				break;
			case 'W':
				this.daysHeld[2]=true;
				break;
			case 'R':
				this.daysHeld[3]=true;
				break;
			case 'F':
				this.daysHeld[4]=true;
				break;
			}
		}
	}
	
	public String toString() {
		return professorName + " -- " + daysHeld + " -- " + timeHeld + " -- " + roomNumber;
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
	
	public boolean[] getDaysHeld() {
		return this.daysHeld;
	}
	
	public void setDaysHeld(String days) {
		for(char c:days.toCharArray()) {
			switch(c) {
			case 'M':
				this.daysHeld[0]=true;
				break;
			case 'T':
				this.daysHeld[1]=true;
				break;
			case 'W':
				this.daysHeld[2]=true;
				break;
			case 'R':
				this.daysHeld[3]=true;
				break;
			case 'F':
				this.daysHeld[4]=true;
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
