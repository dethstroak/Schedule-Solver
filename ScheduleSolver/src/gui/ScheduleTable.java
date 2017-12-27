package gui;

import objects.Course;
import objects.Schedule;
import toolbox.CsvReader;
import toolbox.ScheduleWriter;

import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JFrame;

/**
 * Graphical Representation of Schedule to make it clear when the user will have classes
 * @author Justin Krum
 */
public class ScheduleTable {

	private JFrame guiFrame;
	private Schedule schedule;
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleTable window = new ScheduleTable(10);
					window.guiFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application
	 */
	public ScheduleTable(int scheduleNumber){
		
		//Initialize Schedule values
		schedule = new Schedule(CsvReader.getCourses("files/output/schedule" + scheduleNumber + ".csv"));
		
		initialize(scheduleNumber);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int scheduleNum) {
		
		int frameWidth = schedule.getCoursesTaught().length * 175;
		
		//Setup JFrame
		guiFrame = new JFrame();
		guiFrame.setResizable(false);
		guiFrame.setFont(new Font("Arial", Font.PLAIN, 16));
		guiFrame.setTitle("Graphical Representation of Schedule " + scheduleNum);
		guiFrame.setBounds(400, 100, frameWidth, 750);;
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.getContentPane().setLayout(null);
		
		
	}
	
}
