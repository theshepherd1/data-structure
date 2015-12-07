package bp;

public class Index<Integer> {
	private int row;
	private int col;
	
	public Index(int pRow, int pCol) {
		setRow(pRow);
		setCol(pCol);
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
