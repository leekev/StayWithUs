import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Gui extends JPanel{

	/*private JFrame frame;
	private JTextArea output;
	private JTextArea input;*/
    
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void run() throws IOException {
	    JFrame f = new JFrame();
	    f.addWindowListener(new WindowAdapter() {
	         @Override
            public void windowClosing(WindowEvent e) {
	            System.exit(0);
	         }
	      });
	      f.setContentPane(new Gui());
	      f.setSize(1000, 1000);
	      f.setVisible(true);
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
	        JPanel panel = new JPanel();
	        JPanel buttons = new JPanel();
	        buttons.setBackground(Color.BLACK);
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setPreferredSize(new Dimension(1000, 1000));
	        buttons.setPreferredSize(new Dimension(100, 100));
	        panel.setBackground(Color.BLACK);
	        JLabel text = new JLabel("Welcome to Stay With Us 2.0");
	        text.setAlignmentX(CENTER_ALIGNMENT);
	        JButton play = new JButton("Play Game");
	        play.addActionListener(new ActionListener() {
	                @Override
	                    public void actionPerformed(ActionEvent e) {
	                        JFrame nextframe = new JFrame();
	                        nextframe.setSize(1000, 1000);
	                        JTextArea output = new JTextArea();
	                        PrintStream out = new PrintStream(new TextAreaOutputStream(output));
	                        System.setOut(out);
	                        output.setPreferredSize(new Dimension(1000, 500));
	                        output.setBorder(BorderFactory.createCompoundBorder(output.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	                        output.setFont(new Font("Courier New", Font.PLAIN, 12));
	                        output.setForeground(Color.GREEN);
	                        output.setBackground(new Color(0, 0, 0));
	                        output.setRows(16);
	                        nextframe.getContentPane().add(output, BorderLayout.NORTH);
	                        output.setEditable(false);
	                        JTextArea input = new JTextArea();
	                        input.setPreferredSize(new Dimension(1000, 445));
	                        input.setBorder(BorderFactory.createCompoundBorder(input.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	                        input.setFont(new Font("Courier New", Font.PLAIN, 13));
	                        input.setRows(9);
	                        nextframe.getContentPane().add(input, BorderLayout.SOUTH);
	                        nextframe.setVisible(true);                  
	                    }         
	                });
	        play.setBackground(Color.LIGHT_GRAY);
	        JButton help = new JButton("How to Play");
	        help.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame nextframe = new JFrame();
                        HowToPlayFrame howToPlayImage = new HowToPlayFrame();
                        nextframe.setSize(1050, 1050);
                        nextframe.setBackground(Color.BLACK);
                        nextframe.setPreferredSize(new Dimension(1000, 1000));
                        nextframe.add(howToPlayImage);
                        nextframe.setVisible(true);                  
                    }         
	        });
	        help.setBackground(Color.LIGHT_GRAY);
	        text.setFont(new Font("Helvetica", Font.PLAIN, 50));
	        text.setForeground(Color.GREEN);
	        panel.add(text);
	        buttons.add(play);
	        buttons.add(help);
	        panel.add(buttons);
	        add(panel);
	}
	
}