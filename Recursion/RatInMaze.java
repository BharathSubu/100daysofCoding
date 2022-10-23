
import java.util.*;

public class RatInMaze {
    static ArrayList<String> res = new ArrayList<>();
    static StringBuilder str = new StringBuilder();
    public static ArrayList<String> findPath(int[][] m, int n) {
        int row = m.length , col = m[0].length ;
        int[][] visited=new int[row][col];
        if(m[0][0] == 0) return res;
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], 0);
        }
        findPath(m,visited , row , col , 0,0);

      
        ArrayList<String> result = new ArrayList<>(res);
        res.clear();
        str  = new StringBuilder();
        return result;
    }

    static void findPath(int[][] m,int visited[][], int row , int col , int posi, int posj) {
        visited[posi][posj] = 1;
       
        if (posi == row-1 && posj == col-1 && m[posi][posj] == 1) {
            String result = str.toString();
            res.add(result);
            visited[posi][posj] = 0;
            return;
        }
        // moveup
        if (posi != 0 && m[posi -1][posj] != 0 && visited[posi -1][posj] != 1 ) {
            str.append("U");
            findPath(m,visited, row,col, posi -1, posj);
            str.deleteCharAt(str.length() -1);
        }
        // moveleft
        if (posj != 0  && m[posi][posj-1] != 0 && visited[posi][posj-1] != 1 ) {
            str.append("L");
            findPath(m,visited, row,col, posi, posj-1);
            str.deleteCharAt(str.length() -1);
        }
        // moveright
        if (posj != col - 1 && m[posi][posj+1] != 0 && visited[posi][posj+1] != 1 ) {
            str.append("R");
            findPath(m,visited, row,col, posi, posj+1);
            str.deleteCharAt(str.length() -1);
        }
        // movedown
        if (posi != row - 1  && m[posi+1][posj] != 0 && visited[posi+1][posj] != 1 ) {
            str.append("D");
            findPath(m,visited, row,col,posi+1, posj);
            str.deleteCharAt(str.length() -1);
        }
        visited[posi][posj] = 0;
        return ;
    }

    public static void main(String[] args) {

    int n = 4;
    int[][] maze = {{ 1, 0, 0, 0 },
                    { 1, 1, 0, 1 },
                    { 1, 1, 0, 0 },
                    { 0, 1, 1, 1 } };
   
    ArrayList<String> res = findPath(maze, n);
    System.out.println(res);

    }
}
