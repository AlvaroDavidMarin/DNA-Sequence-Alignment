package Sequencing;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DPM extends Cell{

	static JTextArea MATRIX = new JTextArea();
	static int M;
	static int N;
	static String Matstr="";
	
	public DPM() {
		super();
	}
	
	public static int[][] Intialization_Step(String Seq1, String Seq2, int Match, int MisMatch, int Gap) {
		 M = Seq1.length() + 1;
		 N = Seq2.length() + 1;
		 Matstr="";

		int[][] Matrix = new int[M][N];
		// Initialize the first Row With Gap Penalty Equal To i*Gap
		for (int i = 1; i < M; i++) {
			Matrix[i][0] = i*Gap;
			Matstr += i*Gap + "  ";
			
		}

		// Initialize the first Column With Gap Penalty Equal To i*Gap
		for (int i = 1; i < N; i++) {
			Matrix[0][i] =  i * Gap;
			Matstr += i*Gap + "\n";
		}
		return Matrix;
	}
	public static void PrintInitMatrix(int[][] Matrix, String Seq1, String Seq2) {
		JFrame frame = new JFrame("Inital");
		MATRIX = new JTextArea(M,N);
		
			
			MATRIX.setText(Matstr);
			frame.add(MATRIX);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Intial");
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true); 
			

	}
	
}
