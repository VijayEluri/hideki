
public class Queens {
	private boolean[][] queenOnSquare = null;
	
	private boolean[] colEmpty = null;
	private boolean[] upDiagnoEmpty = null;
	private boolean[] downDiagnoEmpty = null;
	
	private int boardsize = 0;
	private int soluationfound = 0;
	private int soluationTarget = 1;
	
	public Queens(int n){
		boardsize = n;
		
		queenOnSquare = new boolean[boardsize][boardsize];
		for(int row = 0; row < boardsize;row++){
			for(int col = 0; col < boardsize; col++){
				queenOnSquare[row][col] = false;
			}
		}
		colEmpty = new boolean[boardsize];
		for(int col = 0; col < boardsize; col++){
			colEmpty[col] = true;	
		}
		upDiagnoEmpty = new boolean[boardsize*2];
		downDiagnoEmpty = new boolean[boardsize*2];
		for(int i = 0; i < boardsize * 2; i++){
			upDiagnoEmpty[i] = true;
			downDiagnoEmpty[i] = true;
		}
		
	}
	
	public void placeQueen(int row, int col){
		queenOnSquare[row][col] = true;
		
		colEmpty[col] = false;
		upDiagnoEmpty[col + row] = false;
		downDiagnoEmpty[boardsize - 1 + row - col] = false;
	}
	public void removeQueen(int row, int col){
		queenOnSquare[row][col] = false;
		
		colEmpty[col] = true;
		upDiagnoEmpty[col + row] = true;
		downDiagnoEmpty[boardsize - 1 + row - col] = true;
	}
	public boolean isSafe(int row, int col){
		return (colEmpty[col] && this.upDiagnoEmpty[row + col] && downDiagnoEmpty[boardsize - 1 + row - col]);
	}
	public void display(){
		for(int row = 0; row < boardsize;row++){
			for(int col = 0; col < boardsize; col++){
				if(queenOnSquare[row][col]) System.out.print(" Q ");
				else System.out.print(" - ");
			}
			System.out.println();
		}
		
	}
	public void findSafeColumn(int row){
		if(row == boardsize){
			//found!!!
			System.out.println("found");
			display();
			soluationfound++;
			if(this.soluationfound >= this.soluationTarget){
				System.exit(0);
			}
			return;
		}
		
		for(int col = 0; col < this.boardsize; col++){
			if(isSafe(row, col)){
				placeQueen(row, col);
				findSafeColumn(row+1);
				removeQueen(row, col);
			}
		}
	}
	
	public static void main(String[] args){
		Queens queens = new Queens(4);
		for(int row = 0; row < 4; row++){
			queens.findSafeColumn(row);
		}
	}
}
