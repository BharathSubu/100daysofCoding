// https://leetcode.com/problems/word-search/
import java.util.*;

public class WordSearch {
    StringBuilder res = new StringBuilder();
    int row = 0;
    int col = 0;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        if(row == col && row == 0){
            if(board[0][0]==word.charAt(0)) return true;
            return false;
        }
        for(int i = 0 ; i< row ; i++){
            for(int j = 0 ; j<col ; j++){
                if(exist(board, word, i, j)) return true;
            }
        }
         return false;
    }

    boolean exist(char[][] board, String word, int posi, int posj) {
        System.out.println(res);
        // res.append(board[posi][posj]);
       
        
        if (res.length() >= word.length()) {
            String result = res.toString();
            if (result.equals(word)) {
                return true;
            }
            return false;
        }
        char ch = board[posi][posj];
        res.append(ch);
        // moveup
        if (posi != 0 && posi < row) {
            char chNext = board[posi-1][posj];
            if (chNext != '-') {
                board[posi][posj] = '-';
                if (exist(board, word, posi - 1, posj)) {
                    return true;
                }
                board[posi][posj] = ch;
            }
        }
        // moveleft
        if (posj != 0) {
            char chNext = board[posi][posj-1];
            if (chNext != '-') {
                board[posi][posj ] = '-';
                if (exist(board, word, posi, posj - 1)) {
                    return true;
                }
                board[posi][posj ] = ch;
            }
        }
        // moveright
        if (posj != col - 1) {
            char chNext = board[posi][posj+1];
            if (chNext != '-') {
                board[posi][posj] = '-';
                if (exist(board, word, posi, posj + 1)) {
                    return true;
                }
                board[posi][posj ] = ch;
            }
        }
        // movedown
        if (posi != row - 1) {

            char chNext = board[posi+1][posj];
            if (chNext != '-') {
                board[posi][posj] = '-';
                if (exist(board, word, posi+1, posj)) {
                    return true;
                }
                board[posi][posj] = ch;
            }
        }
        if (res.length() == word.length()) {
            String result = res.toString();
            if (result.equals(word)) {
                return true;
            }
            
        }
        res.deleteCharAt(res.length() - 1);
        return false;
    }

    public static void main(String[] args) {

        WordSearch sol = new WordSearch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "AS";
        
        System.out.println(sol.exist(board, word));

    }
}