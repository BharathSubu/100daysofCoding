
//https://leetcode.com/problems/valid-sudoku/

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            HashSet<Character> map = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if((board[i][j] != '.') &&map.contains(board[i][j])){
                    return false;
                }
                map.add(board[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            HashSet<Character> map = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if((board[j][i] != '.') && map.contains(board[j][i])){
                    return false;
                }
                map.add(board[j][i]);
            }
        }

        for (int z = 0; z < 9; z++) {
            HashSet<Character> map = new HashSet<>();
            for (int k = 0; k < 9; k++) {
                //traversing the 3*3 box
                int i = 3 * (z / 3) + k / 3;
                int j =3 * (z%3) + k%3 ;
                // System.out.print(i+" "+j+" - ");
                if (i!=9 && j!=9 && board[i][j] != '.' && map.contains(board[i][j]) )
                    return false;
                map.add(board[i][j]);
            }
            // System.out.println();
        }
        return true;
    }
}
