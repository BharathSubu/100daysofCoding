//https://leetcode.com/contest/weekly-contest-329/problems/sort-the-students-by-their-kth-score/
import java.sql.SQLOutput;
import java.util.*;

public class SortTheStudentsbyTheirKthScore {

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(a,b)->{
            return b[k]-a[k];
        });
        for(int [] arr : score)
        System.out.println(Arrays.toString(arr));
        return score;

    }

}
