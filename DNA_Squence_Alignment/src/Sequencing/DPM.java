package Sequencing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * The GUI Class is used at the beginning of the program and any time a new DNA sequence alignment is required.
 * The class is used to store the text input from the user and determines if it is valid and to send to option menu class
 * The GUI class extends to the DPM class in order to do calculations later on 
 * @author Alvaro Marin
 * @version 4.20.0
 * 
 */
public class DPM {

	static JTextArea MATRIX = new JTextArea();
	static JFrame frame = new JFrame("Inital");
	static int M;
	static int N;

	
	public DPM() {
		super();
	}
	
	public static int[][] Intialization_Step(String Seq1, String Seq2, int Match, int MisMatch, int Gap) {
		 M = Seq1.length() + 1;
		 N = Seq2.length() + 1;
		

		int[][] Matrix = new int[M][N];
		// Initialize the first Row With Gap Penalty Equal To i*Gap
		for (int i = 1; i < M; i++) {
			Matrix[i][0] = i*Gap;		
		}
		// Initialize the first Column With Gap Penalty Equal To i*Gap
		for (int i = 1; i < N; i++) {
			Matrix[0][i] =  i * Gap;	
		}
		return Matrix;
	}
	public static int[][] Get_Max(int i, int j, String Seq1, String Seq2, int[][] Matrix, int Match, int MisMatch,
			int GapPenality) {

		int[][] Temp = new int [i+1][j+1];

		int Sim;
		int Gap = GapPenality;

		if (Seq1.charAt(i - 1) == Seq2.charAt(j - 1))
			Sim = Match;
		else
		Sim = MisMatch;
		// Get values for cells around new cell
		int M1, M2, M3;
		// Diagonal
		M1 = Matrix[i - 1][j - 1] + Sim;
		// above
		M2 = Matrix[i][j - 1] + Gap;
		// left
		M3 = Matrix[i - 1][j] + Gap;
		// check which cell is the highest

		if (M1 >= M2 && M1 >= M3) {
			Temp [i][j]= M1;
		} else {
			if (M2 >= M1 && M2 >= M3) {
				Temp[i][j]= M2;
			} else {
				if (M3 >= M1 && M3 >= M2) {
					Temp[i][j] = M3;
				}
			}
		}

		return Temp;
	}
	public static int[][] FinalMatrix(int[][] Matrix, String Seq1, String Seq2, int Match, int MisMatch, int Gap) {
		int M = Seq1.length() + 1;
		int N = Seq2.length() + 1;
		// Fill Matrix with each cell has a value result from method Get_Max
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				Matrix[i][j] = Get_Max(i, j, Seq1, Seq2, Matrix, Match, MisMatch, Gap)[i][j];
			}
		}

		return Matrix;
	}
	
	public static DNA Traceback(String dna1, String dna2) {
		// Adds character depending on match and score
		if (dna1.length() == 0 && dna2.length() == 0) {
			return new DNA();

		} else if (dna1.length() == 0) {
			DNA result = Traceback(dna1, dna2.substring(1));
			result.addMatch('_', dna2.charAt(0));
			return result;

		} else if (dna2.length() == 0) {
			DNA result = Traceback(dna1.substring(1), dna2);
			result.addMatch(dna1.charAt(0), '_');
			return result;

		} else {
			DNA first = Traceback(dna1.substring(1), dna2);
			first.addMatch(dna1.charAt(0), '_');

			DNA second = Traceback(dna1, dna2.substring(1));
			second.addMatch('_', dna2.charAt(0));

			DNA both = Traceback(dna1.substring(1), dna2.substring(1));
			both.addMatch(dna1.charAt(0), dna2.charAt(0));

			if (first.score() >= second.score() && first.score() >= both.score()) {
				return first;

			} else if (second.score() >= first.score() && second.score() >= both.score()) {
				return second;

			} else {

				return both;
			}
		}
	}

	
	public static void PrintMatrix(int[][] Matrix, String Seq1, String Seq2) {
		frame = new JFrame("Inital");
		JPanel Matpanel = new JPanel(new GridLayout(0,1));
		MATRIX = new JTextArea(M,N);
		String test = new String();
		
		
		for (int[]row : Matrix) {
			test += Arrays.toString(row) + "\n";
		}
			MATRIX.setText(test);
			Matpanel.add(MATRIX);
			Matpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.add(Matpanel,BorderLayout.CENTER);
			frame.setTitle("Matrix");
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true); 
			
	}
	
}
