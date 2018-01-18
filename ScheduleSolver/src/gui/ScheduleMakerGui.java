package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import toolbox.CsvReader;
import toolbox.ScheduleWriter;

/**
 * GUI prompts user for ScheduleWriter information
 * @see toolbox.ScheduleWriter
 */
public class ScheduleMakerGui {

	private JFrame frmScheduleSolver;
	private JTextField inputValuesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleMakerGui window = new ScheduleMakerGui();
					window.frmScheduleSolver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScheduleMakerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScheduleSolver = new JFrame();
		frmScheduleSolver.setResizable(false);
		frmScheduleSolver.setFont(new Font("Arial", Font.PLAIN, 16));
		frmScheduleSolver.setTitle("Schedule Solver");
		frmScheduleSolver.setBounds(100, 100, 360, 240);
		frmScheduleSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduleSolver.getContentPane().setLayout(null);

		//		inputValuesField = new JTextField();
		//		inputValuesField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		//		inputValuesField.setBounds(157, 39, 167, 20);
		//		frmScheduleSolver.getContentPane().add(inputValuesField);
		//		inputValuesField.setColumns(10);
		//		
		//		JLabel lblClassesValuesFile = new JLabel("Courses Values File Name:");
		//		lblClassesValuesFile.setForeground(Color.BLACK);
		//		lblClassesValuesFile.setBackground(Color.WHITE);
		//		lblClassesValuesFile.setFont(new Font("Times New Roman", Font.BOLD, 12));
		//		lblClassesValuesFile.setBounds(10, 42, 148, 14);
		//		frmScheduleSolver.getContentPane().add(lblClassesValuesFile);

		JButton btnChooseCourseList = new JButton("Choose Course List");
		btnChooseCourseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(frmScheduleSolver);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
			            File file = fc.getSelectedFile();
			            ScheduleWriter.makeScheduleFile(CsvReader.getCourses(file));
			            System.out.println("Opening: " + file.getName() + ".");
			        } else {
			            System.out.println("Open command cancelled by user.");
			        }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnChooseCourseList.setBounds(5, 5, 345, 95);
		frmScheduleSolver.getContentPane().add(btnChooseCourseList);
		
		JButton btnCreateCourseList = new JButton("Create Course List");
		btnCreateCourseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCreateCourseList.setBounds(5, 105, 345, 95);
		frmScheduleSolver.getContentPane().add(btnCreateCourseList);
	}
}
