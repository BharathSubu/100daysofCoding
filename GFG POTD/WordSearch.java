//https://practice.geeksforgeeks.org/problems/word-search/1
import java.util.*;
public class WordSearch {
    public boolean isWordExist(char[][] board, String word)
    {
        int n = board.length , m = board[0].length;

        boolean vis[][] = new boolean[n][m];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));

        boolean ans = false;

        outer:
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    ans = find(i,j,0,vis,board,word);
                }
                if(ans) break outer;
            }
        }
        return ans;
    }

    public boolean find(int i , int j , int pos, boolean[][]vis,char[][]board,String word){
        if(board[i][j] == word.charAt(pos))
        {
            pos++;
        }
        else return false;

        if(pos == word.length()) return true;

        vis[i][j]=true;
        boolean ans = false;
        int dr[] = {0,-1,+1,0};
        int dc[] = {-1,0,0,+1};

        for(int k = 0; k<4; k++){
            int nrow = i + dr[k];
            int ncol = j + dc[k];
            if(nrow >= 0 && nrow < vis.length && ncol >= 0 && ncol < vis[0].length && !vis[nrow][ncol]){
                ans = find(nrow,ncol,pos,vis,board,word);
            }
            if(ans) break;
        }
        vis[i][j] = false;
        return ans;
    }

}
