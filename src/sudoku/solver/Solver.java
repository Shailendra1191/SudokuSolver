package sudoku.solver;

/**
 * 
 * @author Shailendra Choudhary
 * @since
 */
public class Solver {
	
	int[][] grid;
	
	public boolean solve(int[][] grid) {
		this.grid=grid;
		
		boolean result=true;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(grid[i][j]==0) {
					result=false;
					for(int k=1;k<10;k++) {
						if(isInsertPossible(i, j, k)) {
							grid[i][j]=k;
							result|=solve(grid);
							if(!result)
								grid[i][j]=0;
						}
					}
					return result;
				}
			}
		}
		return result;
	}
	
	private boolean isInsertPossible(int x,int y,int n) {
		for(int i=0;i<9;i++) {
			if(grid[x][i]==n) return false;
		}
		for(int i=0;i<9;i++) {
			if(grid[i][y]==n) return false;
		}
		int x1=3*(x/3);
		int y1=3*(y/3);
		for(int i=x1;i<x1+3;i++) {
			for(int j=y1;j<y1+3;j++) {
				if(grid[i][j]==n) return false;
			}
		}
		
		return true;
	}
	

}
