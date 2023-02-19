//https://leetcode.com/problems/circular-array-loop/description/
import java.util.*;
public class CicularArrayLoop {


    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int dist[] = new int[n];
        int vis[] = new int[n];
        Arrays.fill(dist,-1);
        Arrays.fill(vis,0);
        int group = 1;
        HashSet<Integer> goodStones = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                if(findCycle(i,0,group,dist,vis,nums,goodStones)){
                    return true;
                }
                else{
                    goodStones.add(group);
                }
                group++;
            }
        }
    }

    private boolean findCycle(int i, int pos, int group,int[] dist, int[] vis, int[] nums,  HashSet<Integer> goodStones) {
        vis[i] = group;
        dist[i] = pos;
        int next = i + nums[i];
        if(next < 0){
            int num = -1 * next;
            next%=nums.length;
            next = nums.length - next;
        }
        else if(next >= nums.length){
            next%= nums.length;
        }
        if(vis[next] != 0 && goodStones.contains(next)) return false;
        else if(vis[next] != 0 && !goodStones.contains(next)) return true;
        else if(dist[next] != -1 && Math.abs(pos - dist[next]) > 1) return false;
        else return findCycle(next,pos+1,group,dist,vis,nums,goodStones);
    }
}
