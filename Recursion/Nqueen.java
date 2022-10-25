// https://leetcode.com/problems/n-queens/
import java.util.*;

public class Nqueen {

    StringBuilder qstr = new StringBuilder();
    List<List<String>> res = new ArrayList<>();
    List<StringBuilder> strarr = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            qstr.append('.');
        }
        for (int i = 0; i < n; i++) {
            strarr.add(new StringBuilder(qstr));
        }
        solveNQueens(n, 0);
        return res;
    }

    boolean isqueensafe(int queenpos, int cursquare, List<StringBuilder> strarr) {
        for (int i = 0; i < strarr.size(); i++) {
            if (strarr.get(i).charAt(cursquare) == 'Q' && i != queenpos)
                return false;
        }

        int crossi = queenpos;
        int crossj = cursquare;

        while (crossi != 0 && crossj != 0) {
            crossj--;
            crossi--;
        }

        while (crossi != strarr.size() && crossj != strarr.size()) {
            if (strarr.get(crossi).charAt(crossj) == 'Q' && (crossi != queenpos && crossj != cursquare)) {
                return false;
            }
            crossj++;
            crossi++;
        }
        // cout<<"checking cross right to left....\n";

        crossi = queenpos;
        crossj = cursquare;
        // cout<<crossi<<" "<<crossj<<"\n";

        while (crossi != 0 && crossj != strarr.size() - 1) {
            crossj++;
            crossi--;
        }

        while (crossi != strarr.size() && crossj != -1) {
            if (strarr.get(crossi).charAt(crossj) == 'Q' && (crossi != queenpos && crossj != cursquare)) {
                return false;
            }
            crossj--;
            crossi++;
        }

        return true;
    }

    void solveNQueens(int n, int pos) {
        if (pos == n) {
            List<String> newarr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                newarr.add(strarr.get(i).toString());
                System.out.println(strarr.get(i));
            }
            System.out.println();
            res.add(new ArrayList<>(newarr));
            return;
        }

        for (int j = 0; j < n; j++) {
            strarr.get(pos).setCharAt(j, 'Q');
            int next = pos + 1;
            if(isqueensafe(pos, j, strarr))
            solveNQueens(n, next);
            strarr.get(pos).setCharAt(j, '.');
        }

    }

    public static void main(String[] args) {

        Nqueen sol = new Nqueen();
        List<List<String>> res = sol.solveNQueens(4);
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {

            System.out.println();
        }
        System.out.println("End");
    }
}