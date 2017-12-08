package objects;

import java.time.LocalTime;

/**
 * Data type for containing information about valid schedules
 * 
 * @author Justin Krum
 */
public class Schedule {

	Course[] courses;
	LocalTime finalEndTime, firstStartTime;
	boolean[] daysArray;
	
	String professorNames[], 
			coursesTaught[], 
			timesHeld[], 
			daysHeld[];

	int totalCreditHours;

	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public Schedule(Course[] courseList) {
		
		this.courses = courseList;
		
		setFirstStartTime(courseList);
		setFinalEndTime(courseList);
		
		setDaysArray(courseList);
		
		setProfessorNames(courseList);
		setCoursesTaught(courseList);
		setTimesHeld(courseList);
		setDaysHeld(courseList);
		
		setTotalCreditHours(courseList);
	}
	
	public String toString(){
		String returnString = "";
		for(Course c : this.courses){
			returnString += c.toString() + "\n";
		}
		return returnString;
	}
	
	/**
	 * 
	 * @return Latest end-time out of all the Course values in the Schedule
	 */
	public LocalTime getFinalEndTime() {
		return finalEndTime;
	}
	
	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setFinalEndTime(Course[] courseList) {
		this.finalEndTime = courseList[0].getEndTime();
		
		for (int i = 1; i < courseList.length; i++) {
			if(courseList[i].getEndTime().isAfter(this.finalEndTime)) {
				this.finalEndTime = courseList[i].getEndTime();
			}
		}
	}
	
	public LocalTime getFirstStartTime() {
		return firstStartTime;
	}
	
	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setFirstStartTime(Course[] courseList) {
		this.firstStartTime = courseList[0].getStartTime();
				
		for(int i = 1; i < courseList.length; i++) {
			if(courseList[i].getStartTime().isBefore(this.firstStartTime)) {
				this.firstStartTime = courseList[i].getStartTime();
			}
		}
	}

	public boolean[] getDaysArray() {
		return daysArray;
	}
	
	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setDaysArray(Course[] courseList){
		
		this.daysArray = new boolean[5];
		
		for(Course c : courseList){
			for(int i = 0; i < c.getDaysArray().length; i++){
				if(c.getDaysArray()[i] == true){
					this.daysArray[i] = true;
				}
			}
		}		
	}
	
	public Course[] getCourses() {
		return courses;
	}
	
	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	public String[] getProfessorNames() {
		return professorNames;
	}
	
	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setProfessorNames(Course[] courseList) {
		this.professorNames = new String[courseList.length];
		for(int i = 0; i < professorNames.length; i++){
			this.professorNames[i] = courseList[i].getProfessorName();
		}
	}

	public String[] getCoursesTaught() {
		return coursesTaught;
	}

	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setCoursesTaught(Course[] courseList) {
		this.coursesTaught = new String[courseList.length];
		for(int i = 0; i < coursesTaught.length; i++){
			coursesTaught[i] = courseList[i].getCourseTaught();
		}
	}

	public String[] getTimesHeld() {
		return timesHeld;
	}

	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setTimesHeld(Course[] courseList) {
		this.timesHeld = new String[courseList.length];
		for(int i = 0; i < timesHeld.length; i++){
			timesHeld[i] = courseList[i].getTimeHeld();
		}
	}

	public String[] getDaysHeld() {
		return daysHeld;
	}

	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setDaysHeld(Course[] courseList) {
		this.daysHeld = new String[courseList.length];
		for(int i = 0; i < daysHeld.length; i++){
			daysHeld[i] = courseList[i].getDaysHeld();
		}
	}

	public int getTotalCreditHours() {
		return totalCreditHours;
	}

	/**
	 * 
	 * @param courseList Array of Course objects that are in a valid schedule
	 */
	public void setTotalCreditHours(Course[] courseList) {
		this.totalCreditHours = 0;
		for(int i = 0; i < courseList.length; i++){
			this.totalCreditHours += courseList[i].getCreditHours();
		}
	}
	

}
