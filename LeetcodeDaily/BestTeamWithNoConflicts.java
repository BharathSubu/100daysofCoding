//https://leetcode.com/problems/best-team-with-no-conflicts
import java.util.Arrays;

public class BestTeamWithNoConflicts {
    class Pair{
        int score,age;
        Pair(int s,int a){
            score = s;
            age = a;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {

        Pair pairs[] = new Pair[scores.length];
        for (int i = 0; i < scores.length; i++) {
            pairs[i] = new Pair(scores[i], ages[i]);
        }
        Arrays.sort(pairs, (a, b) ->
                {
                    if(a.score == b.score){
                        return a.age- b.age;
                    }
                    return a.score-b.score;
                }
        );

        int dp[] = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            dp[i] = pairs[i].score;
        }
        int ans = -1;
        for (int i = 0; i < scores.length; i++) {
            int currScore = pairs[i].score;
            int currrAge = pairs[i].age;
            for (int j = 0; j < i; j++) {
                if (currrAge >= pairs[j].age) {
                    dp[i] = Math.max(dp[i], (dp[j] + currScore));
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
