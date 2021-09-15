package Sequencing;

public class DPM extends Cell{

	public DPM() {
		super();
	}
	
	public static Cell[][] Intialization_Step(String Seq1, String Seq2, int Match, int MisMatch, int Gap) {
		int M = Seq1.length() + 1;
		int N = Seq2.length() + 1;

		Cell[][] Matrix = new Cell[M][N];
		// Initialize 0,0 to be 0
		Matrix[0][0] = new Cell(0, 0, 0);
		// Initialize the first Row With Gap Penalty Equal To i*Gap
		for (int i = 1; i < M; i++) {
			Matrix[i][0] = new Cell(i, 0, i * Gap);
		}

		// Initialize the first Column With Gap Penalty Equal To i*Gap
		for (int i = 1; i < N; i++) {
			Matrix[0][i] = new Cell(0, i, i * Gap);
		}
		return Matrix;
	}
}
