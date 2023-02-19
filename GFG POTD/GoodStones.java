
//https://practice.geeksforgeeks.org/problems/e2d156755ca4e0a9b9abf5680191d4b06e52b1a8/1
import java.util.*;
public class GoodStones {
    public static int goodStones(int n, int[] arr) {
        int vis[] = new int[n];
        Arrays.fill(vis,0);
        HashSet<Integer> stonePos = new HashSet<>();
        int group = 1;
        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                if(!findCycle(i,vis,group,arr,stonePos)){
                    stonePos.add(group);
                }
                group++;
            }
        }
        int res = 0;
        for(int i : vis) if(stonePos.contains(i)) res++;
        return res;
    }

    private static boolean findCycle(int i, int[] vis, int group, int[] arr, HashSet<Integer> stonePos) {
        vis[i] = group;
        int next = i + arr[i];
        if(next < 0 || next >= arr.length) return false;
        else if(vis[next] != 0 && stonePos.contains(vis[next])) return false;
        else if(vis[next] != 0 && !stonePos.contains(vis[next])) return true;
        else if(vis[next] == group) return true;
        else return findCycle(next,vis,group,arr,stonePos);
    }
}
