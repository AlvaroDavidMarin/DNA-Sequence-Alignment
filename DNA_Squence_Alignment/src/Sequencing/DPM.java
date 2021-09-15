package Sequencing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DPM extends Cell{

	static JTextArea MATRIX = new JTextArea();
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

		int[][] Temp = new int [i][j];

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

	
	public static void PrintMatrix(int[][] Matrix, String Seq1, String Seq2) {
		JFrame frame = new JFrame("Inital");
		JPanel Matpanel = new JPanel(new GridLayout(0,1));
		MATRIX = new JTextArea(M,N);
		String test = new String();
		
		for (int[]row : Matrix) {
			test += Arrays.toString(row) + "\n";
		}
			MATRIX.setText(test);
			Matpanel.add(MATRIX);
			Matpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(Matpanel,BorderLayout.CENTER);
			frame.setTitle("Intial");
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true); 
	}
	
}
