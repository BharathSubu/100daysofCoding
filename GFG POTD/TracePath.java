//https://practice.geeksforgeeks.org/problems/trace-path3840/1
import java.util.*;
public class TracePath {
    static int isPossible(int n, int m, String s){

            int l = 0, r = 0, u = 0,d = 0;
            int  dx = 0, dy = 0;
            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case 'L':
                        dx--;
                        break;
                    case 'R':
                        dx++;
                        break;
                    case 'U':
                        dy--;
                        break;
                    case 'D':
                        dy++;
                        break;
                }
                l = Math.min(l, dx);
                r = Math.max(r, dx);
                u = Math.max(u, dy);
                d = Math.min(d, dy);
            }
            return (r - l < m) && (u - d < n) ? 1 : 0;

    }
}
