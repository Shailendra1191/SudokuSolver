package sudoku.app;

import sudoku.solver.Solver;

public class MainApp {

	public static void main(String[] args) {
		int[][] grid=new int[][] {
			{9,0,0,7,0,0,6,0,0},
			{7,5,0,0,0,0,0,8,0},
			{0,0,6,0,0,0,0,6,0},
			{0,4,0,0,3,0,0,0,0},
			{0,6,7,8,0,0,0,5,0},
			{0,0,0,0,6,0,4,0,0},
			{0,0,9,6,0,0,0,7,0},
			{0,0,8,4,0,0,0,6,5},
			{0,0,0,0,0,2,0,0,1},
		};
		
		System.out.println("Initial Puzzle");
		printGrid(grid);
		Solver solver=new Solver();
		solver.solve(grid);
		
		System.out.println("Solved solution");
		printGrid(grid);

	}
	
	public static void printGrid(int[][] grid) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(grid[i][j]+" ");
				if(j%3==2) System.out.print('|');
			}
			System.out.println();
			if(i%3==2)System.out.println("--------------------");
		}
	}

}
