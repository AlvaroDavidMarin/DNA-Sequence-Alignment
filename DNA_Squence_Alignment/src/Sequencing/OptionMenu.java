package Sequencing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionMenu extends GUI implements ActionListener {
	JTextField First = new JTextField();
	JTextField Second = new JTextField();
	JTextField Match = new JTextField();
	JTextField Mis = new JTextField();
	JTextField Gap = new JTextField();
	
	public OptionMenu(JTextField First, JTextField Second, JTextField Match, JTextField Mis, JTextField Gap ) {		
		this.First = First;
		this.Second = Second;
		this.Match = Match;
		this.Mis = Mis;
		this.Gap = Gap;
	}

	
	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	
	  void Options() {
			 frame = new JFrame("Options");
			 button1 = new JButton("New");
			 button2 = new JButton("Initialized Matrix");
			 button3 = new JButton("Finalize Matrix");
			 button4 = new JButton("Alignment");
			 
			 JLabel label1 = new JLabel("Sequence 1:");
			 JLabel label2 = new JLabel("Sequence 2:");
			 
			 JPanel Labelpanel = new JPanel(new GridLayout(0,1));
			 JPanel Textpanel = new JPanel(new GridLayout(0,1));
			 JPanel buttonPanel = new JPanel(new GridLayout(0,1));
			 
			 button1.addActionListener(this);
			 button2.addActionListener(this);
			 button3.addActionListener(this);
			 button4.addActionListener(this);
			 	 
			 First.setEditable(false);
			 First.setPreferredSize(new Dimension(125,25));
			 Second.setEditable(false);
			 Second.setPreferredSize(new Dimension(125,25));
			 
			 label1.setLabelFor(First);
			 label2.setLabelFor(Second);
			 
			 Labelpanel.add(label1);
			 Labelpanel.add(label2);
			 
			 First.setText(First.getText().toUpperCase());
			 Second.setText(Second.getText().toUpperCase());
			 Textpanel.add(First);
			 Textpanel.add(Second); 
			 
			 buttonPanel.add(button2);
			 buttonPanel.add(button3);
			 buttonPanel.add(button4);
			 buttonPanel.add(button1);
	
			 Labelpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			 Textpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			 buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			 
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.add(Labelpanel,BorderLayout.CENTER);
			 frame.add(Textpanel, BorderLayout.LINE_END);
			 frame.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
			 frame.setTitle("Options");
			 frame.pack();
			 frame.setLocationRelativeTo(null);
			 frame.setVisible(true); 
		
		 }
		 
		 public void actionPerformed(ActionEvent e) {
			 if(e.getSource()== button2) {
				 int match = Integer.parseInt(Match.getText());
				 int mis = Integer.parseInt(Mis.getText());
				 int gap = Integer.parseInt(Gap.getText());
				 int[][] Mat = DPM.Intialization_Step(First.getText(),Second.getText(),match,mis,gap);
				 DPM.frame.dispose();
				 PrintMatrix(Mat,First.getText(),Second.getText());
				 
			 }
			 if(e.getSource() == button3) {
				 int match = Integer.parseInt(Match.getText());
				 int mis = Integer.parseInt(Mis.getText());
				 int gap = Integer.parseInt(Gap.getText());
				 int[][] Mat = DPM.Intialization_Step(First.getText(),Second.getText(),match,mis,gap);
				 int[][] Fine = DPM.FinalMatrix(Mat, First.getText(), Second.getText(), match, match, gap);
				 DPM.frame.dispose();
				 PrintMatrix(Fine,First.getText(),Second.getText());
			 }
			 if(e.getSource() == button4) {
				 DNA Align =Traceback(First.getText(),Second.getText());
				 Align.frame1.dispose();
				 Align.Alignment();
			
				// System.out.println(Align.toString());
			 }
			 if(e.getSource() == button1) {
				 
				 frame.dispose();
				 First.setText(null);
				 Second.setText(null);
				 Start();
			 }
			//Options();
			 
		 }
	

}
