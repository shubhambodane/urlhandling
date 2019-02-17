package urlhanding;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI {
	String Path;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Select Source Project Folder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser f = new JFileChooser();
			     f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
			     f.showSaveDialog(null);
			    System.out.println(f.getCurrentDirectory());
			    Path = f.getSelectedFile().getPath();
			    System.out.println(Path);
			    System.out.println(f.getSelectedFile().getPath());
			}
		});
		btnNewButton.setBounds(30, 40, 211, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Select Destination Folder");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser f = new JFileChooser();
			     f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
			     f.showSaveDialog(null);
			     System.out.println(f.getCurrentDirectory());	     
			     System.out.println(f.getSelectedFile());
			}
		});
			
		btnNewButton_1.setBounds(30, 91, 211, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnRunApplication = new JButton("Run Application");
		btnRunApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			WebXMLParser obj1 = new WebXMLParser();
			try {
				WebXMLParser.convertWebXML();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnRunApplication.setBounds(30, 143, 168, 23);
		frame.getContentPane().add(btnRunApplication);
	}
	public String getPath() {
		return Path;
	}	
}
