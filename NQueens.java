import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, results);
        return results;
    }

    private void solve(int row, char[][] board, List<List<String>> results) {
        int n = board.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board)
                solution.add(new String(r));
            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(row + 1, board, results);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    // Example usage
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> solutions = nq.solveNQueens(4);
        for (List<String> board : solutions) {
            for (String row : board)
                System.out.println(row);
            System.out.println();
        }
    }
}
