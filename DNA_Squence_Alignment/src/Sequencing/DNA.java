package Sequencing;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 
 * The DNA Class is used to perform to 
 * @author Alvaro Marin
 * @version 4.20.0
 * 
 */
public class DNA{
	protected String dna1;
	protected String dna2;
	JFrame frame1 = new JFrame("Inital");
	
	// default constructor for DNA Class
	public DNA() {
		dna1="";
		dna2="";
	}
	// Method to check if inputed Sequences contains appropriate characters 
	public boolean ValidCheck(JTextField check ) {
		String str = check.getText().toString().toUpperCase();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='G') {
			}else if(str.charAt(i)=='A') {
			}else if (str.charAt(i)=='T'){
			}else if (str.charAt(i)=='C') {
			}else 
				return false;
		} return true;
	}
	
	// Method to determine score of the character in a the sequence 
	public int score() {
		int score = 0;
		for (int i = 0; i < dna1.length(); i++) {
			if (dna1.charAt(i) == dna2.charAt(i)) {
				score += 2;
			} else {
				score -= 1;
			}
		}
		return score;
	}
	
	// Method to add a match character to the alignment sequence 
	public void addMatch(char c1, char c2) {
		dna1 = c1 + dna1;
		dna2 = c2 + dna2;
		
	}

	// Method to display the alignment in a new window 
	public void Alignment() {
		frame1 = new JFrame("Inital");
		JPanel Apanel = new JPanel(new GridLayout(0,1));
		JTextArea ALIGN = new JTextArea();

		ALIGN.setText(dna1 + "\n" + dna2);
		Apanel.add(ALIGN);
		Apanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.add(Apanel,BorderLayout.CENTER);
		frame1.setTitle("Matrix");
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true); 
	}
		 

}
