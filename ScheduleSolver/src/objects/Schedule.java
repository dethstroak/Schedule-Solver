package objects;

import java.time.LocalTime;

public class Schedule {

	Course[] courses;
	LocalTime finalEndTime, firstStartTime;
	boolean[] daysArray;
	
	String professorNames[], 
			coursesTaught[], 
			timesHeld[], 
			daysHeld[];

	int totalCreditHours;

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
	
	public LocalTime getFinalEndTime() {
		return finalEndTime;
	}

	public void setFinalEndTime(Course[] courseList) {
		//TODO doesn't work correctly?
		this.finalEndTime = null;
		
		for (int i = 0; i < courseList.length - 1; i++) {
			for(int j = 1; j < courseList.length; j++){
				if(courseList[j].getEndTime().isAfter(courseList[i].getEndTime())){
					this.finalEndTime = courseList[j].getEndTime();
				}
			}
		}
	}
	
	public LocalTime getFirstStartTime() {
		return firstStartTime;
	}
	
	public void setFirstStartTime(Course[] courseList) {
		
		this.firstStartTime = null;
		
		for (int i = 0; i < courseList.length; i++) {
			for(int j = i + 1; j < courseList.length; j++){
				if(courseList[i].getStartTime().isBefore(courseList[j].getStartTime())){
					this.firstStartTime = courseList[i].getStartTime();
				}
			}
		}
		
	}

	public boolean[] getDaysArray() {
		return daysArray;
	}
	
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

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	public String[] getProfessorNames() {
		return professorNames;
	}

	public void setProfessorNames(Course[] courseList) {
		this.professorNames = new String[courseList.length];
		for(int i = 0; i < professorNames.length; i++){
			this.professorNames[i] = courseList[i].getProfessorName();
		}
	}

	public String[] getCoursesTaught() {
		return coursesTaught;
	}

	public void setCoursesTaught(Course[] courseList) {
		this.coursesTaught = new String[courseList.length];
		for(int i = 0; i < coursesTaught.length; i++){
			coursesTaught[i] = courseList[i].getCourseTaught();
		}
	}

	public String[] getTimesHeld() {
		return timesHeld;
	}

	public void setTimesHeld(Course[] courseList) {
		this.timesHeld = new String[courseList.length];
		for(int i = 0; i < timesHeld.length; i++){
			timesHeld[i] = courseList[i].getTimeHeld();
		}
	}

	public String[] getDaysHeld() {
		return daysHeld;
	}

	public void setDaysHeld(Course[] courseList) {
		this.daysHeld = new String[courseList.length];
		for(int i = 0; i < daysHeld.length; i++){
			daysHeld[i] = courseList[i].getDaysHeld();
		}
	}

	public int getTotalCreditHours() {
		return totalCreditHours;
	}

	public void setTotalCreditHours(Course[] courseList) {
		this.totalCreditHours = 0;
		for(int i = 0; i < courseList.length; i++){
			this.totalCreditHours += courseList[i].getCreditHours();
		}
	}
	

}
