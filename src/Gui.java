import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Gui {

	private JFrame frame;
	private JTextArea output;
	private JTextArea input;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 Create the application.
	 * @throws IOException 
	 */
	public Gui() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(1000, 2000, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		output = new JTextArea();
		
		output.setBorder(BorderFactory.createCompoundBorder(output.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		output.setFont(new Font("Courier New", Font.PLAIN, 12));
		output.setForeground(Color.GREEN);
		output.setBackground(new Color(0, 0, 0));
		output.setRows(16);
		frame.getContentPane().add(output, BorderLayout.NORTH);
		output.setEditable(false);
		
		input = new JTextArea();
		input.setBorder(BorderFactory.createCompoundBorder(input.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		input.setFont(new Font("Courier New", Font.PLAIN, 13));
		input.setRows(9);
		frame.getContentPane().add(input, BorderLayout.SOUTH);
	}
}