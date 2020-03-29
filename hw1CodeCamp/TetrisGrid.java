//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	

	private boolean lineIsFull(int y){
		int height = grid[0].length;
		int width = grid.length;
		int count = 0;
		int x;
		if(y == height)
			return false;
		for (x = 0; x < width; x++){
			if (grid[x][y])
				count++;
		}
		return (count == x) ? true : false;
	}

	private void shift(int y, int lines){
		int width = grid.length;
		int height = grid[0].length;
		if (lines == 0)
			return ;
		for (int i = 0;y + lines + i < height;i++){
		 	for (int n = 0; n < width;n++){
		 		grid[n][y + i] = grid[n][y + lines + i];
			}
		 }
		while(lines > 0){
			for (int i = 0; i < width; i++)
				grid[i][height - lines] = false;
			lines--;
		}
	}

	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int height = grid[0].length;
		for (int y = 0; y < height; y++)
		{
			int i;
			for (i = 0; lineIsFull(y + i); i++){
			}
			shift(y, i);
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
