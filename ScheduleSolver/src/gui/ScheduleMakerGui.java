package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import toolbox.CsvReader;
import toolbox.ScheduleWriter;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
		frmScheduleSolver.setBounds(100, 100, 348, 140);
		frmScheduleSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduleSolver.getContentPane().setLayout(null);
		
		inputValuesField = new JTextField();
		inputValuesField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputValuesField.setBounds(157, 39, 167, 20);
		frmScheduleSolver.getContentPane().add(inputValuesField);
		inputValuesField.setColumns(10);
		
		JLabel lblClassesValuesFile = new JLabel("Courses Values File Name:");
		lblClassesValuesFile.setForeground(Color.BLACK);
		lblClassesValuesFile.setBackground(Color.WHITE);
		lblClassesValuesFile.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblClassesValuesFile.setBounds(10, 42, 148, 14);
		frmScheduleSolver.getContentPane().add(lblClassesValuesFile);
		
		JButton btnMakeSchedule = new JButton("Make Schedules");
		btnMakeSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputTextValue = inputValuesField.getText();
				try {
					ScheduleWriter.makeScheduleFile(CsvReader.getCourses("files/input/" + inputTextValue + ".csv"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnMakeSchedule.setBounds(97, 70, 129, 23);
		frmScheduleSolver.getContentPane().add(btnMakeSchedule);
	}
}
