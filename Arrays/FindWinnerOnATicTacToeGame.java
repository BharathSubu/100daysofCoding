//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/
import java.util.*;
public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[][] mat = new int[3][3];
        Arrays.stream(mat).forEach(a-> Arrays.fill(a,100));
        boolean isX = true;
        for(int [] m : moves){
            if(isX) mat[m[0]][m[1]] = 1;
            else mat[m[0]][m[1]] = 0;
            isX = isX ? false : true ;
        }
        int[] i = {0,0,0,1};
        int[] j = {0,1,2,0};
        int[] k = {2,2,2,1};
        int[] l = {2,1,0,2};
        for (int x = 0; x < 4; x++) {
            int sum = mat[i[x]][j[x]] + mat[k[x]][l[x]] + mat[1][1];
            if(sum == 0) return "B";
            if(sum == 3) return "A";
        }
        int y = 0;
        for (int x = 0; x < 2; x++) {
            int sum =0;
            for (int z = 0; z< 3; z++) {
                sum+=mat[y][z];
            }
            if(sum == 0) return "B";
            if(sum == 3) return "A";

            sum = 0;
            for (int z = 0; z< 3; z++) {
                sum+=mat[z][y];
            }
            if(sum == 0) return "B";
            if(sum == 3) return "A";
            y+=2;
        }
        if(moves.length == 9)
            return "Draw";
        return "Pending";
    }
}
