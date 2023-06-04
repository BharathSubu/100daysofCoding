//https://leetcode.com/problems/similar-string-groups/
import java.util.*;
public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        boolean vis[] = new boolean[strs.length];
        Arrays.fill(vis,false);
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if(!vis[i]){
                count++;
                Queue<Integer> qu = new LinkedList<>();
                qu.add(i);
                while (!qu.isEmpty()){
                    int parent = qu.remove();
                    if(!vis[parent]) {
                        vis[parent] = true;
                        for (int j = 0; j < strs.length; j++) {
                            if(!vis[j]){
                                if(isSimilar(strs[parent],strs[j])) qu.add(j);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean isSimilar(String toString, String str) {
        int count = 0;
        for (int i = 0; i < toString.length(); i++) {
            if(toString.charAt(i) != str.charAt(i)) count++;
        }
        return count == 2 || count == 0;
    }
}
