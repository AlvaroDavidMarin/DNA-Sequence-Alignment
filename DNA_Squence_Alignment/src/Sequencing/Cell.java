package Sequencing;

public class Cell {
	protected int CellColumn;
	protected int CellRow;
	protected int Score;
	
	public Cell(int i, int j, int Score) {
		this.CellRow = i;
		this.CellColumn = j;
		this.Score = Score;
	}
	
	public Cell() {
		this(0, 0, 0);
	}
}
