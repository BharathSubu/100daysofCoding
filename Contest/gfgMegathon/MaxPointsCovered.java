import java.util.*;

//https://practice.geeksforgeeks.org/contest/mega-job-a-thon-hiring-challenge-for-freshers/instructions/
public class MaxPointsCovered {
    static int maximumpoints(int arr[][], int n, int x, int y) {
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        for (int[] cord : arr) {
            minx = Math.min(minx, cord[0]);
            miny = Math.min(miny, cord[1]);
            maxx = Math.max(maxx, cord[0]);
            maxy = Math.max(maxy, cord[1]);
        }

        int res = 0;
        for (int i = minx; i < maxx; i++) {
            int curr = 0;
            for (int j = miny; j < maxy; j++) {
                int r1 = 0;
                int r2 = 0;
                int r3 = 0;
                int r4 = 0;
                for (int[] cord : arr) {
                    // System.out.println(cord[0]+ " "+cord[1]);
                    if (findPoint(i, j, i + x, j + y, cord[0], cord[1]))
                        r1++;
                    if (findPoint(i, j, i + x, j - y, cord[0], cord[1]))
                        r2++;
                    if (findPoint(i, j, i - x, j + y, cord[0], cord[1]))
                        r3++;
                    if (findPoint(i, j, i - x, j - y, cord[0], cord[1]))
                        r4++;
                }
                curr = Math.max(curr, Math.max(r1, Math.max(r2, Math.max(r3, r4))));
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    static boolean findPoint(int x1, int y1, int x2, int y2, int x, int y) {
        if (x >= x1 && x <= x2 &&
                y >= y1 && y <= y2)
            return true;

        return false;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] Points = { {6,3},{2,9},{8,4},{3,5},{5,6},{9,9},{7,5},{3,1},{8,6},{4,1}};
        System.out.println(maximumpoints(Points, N, 9, 6));

    }
}
