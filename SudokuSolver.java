public class SudokuSolver {

    private static final int BOARD_SIZE = 9;

    private static int[][] board = {
    		// sudoko board to be solved, here 0 represents empty block
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static void main(String[] args) {
        if (solveSudoku()) {
            System.out.println("Sudoku Solved:");
            printBoard();
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
    }

    private static boolean solveSudoku() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
               
                if (board[row][col] == 0) {
                   
                    for (int num = 1; num <= BOARD_SIZE; num++) {
                        if (isValidMove(row, col, num)) {
                            
                            board[row][col] = num;

                           
                            if (solveSudoku()) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                 
                    return false;
                }
            }
        }
      
        return true;
    }

    private static boolean isValidMove(int row, int col, int num) {
       
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

      
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
