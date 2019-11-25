class Solution {
    private boolean isValidSudokuRows(char[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (m[(int) (board[i][j] - '1')]) {
                    return false;
                }
                m[(int) (board[i][j] - '1')] = true;
            }
        }
        return true;
    }

    private boolean isValidSudokuColumns(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (m[(int) (board[i][j] - '1')]) {
                    return false;
                }
                m[(int) (board[i][j] - '1')] = true;
            }
        }
        return true;
    }

    private boolean isValidSudokuBoxes(char[][] board) {
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int il = block / 3 * 3, i = il; i < il + 3; i++) {
                for (int jl = block % 3 * 3, j = jl; j < jl + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return isValidSudokuRows(board) && isValidSudokuColumns(board) && isValidSudokuBoxes(board);
    }
}
