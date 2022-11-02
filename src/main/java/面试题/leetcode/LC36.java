package 面试题.leetcode;

import java.util.HashSet;

public class LC36 {

    public static void main(String[] args) {
        char[][] arr = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new LC36().isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> lines = new HashSet<>();
        HashSet<Character> tables = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !lines.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !rows.add(board[j][i]))
                    return false;

                int x = i % 3 * 3 + j / 3;
                int y = i / 3 * 3 + j % 3;
                if (board[x][y] != '.' && !tables.add(board[x][y]))
                    return false;

            }
            rows.clear();
            lines.clear();
            tables.clear();
        }
        return true;
    }
}
