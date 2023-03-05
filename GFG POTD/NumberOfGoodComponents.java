//https://practice.geeksforgeeks.org/problems/1a4b617b70f0142a5c2b454e6fbe1b9a69ce7861/1
import java.util.*;
public class NumberOfGoodComponents {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> map) {

        boolean vis[] = new boolean[V+1];
        Arrays.fill(vis,false);
        int count = 0;
        for (int i = 1; i <= V; i++) {
            if(!vis[i]){

                    Stack<Integer> st = new Stack<>();
                    dfs(i,vis,map,st);
                    int n = st.size();
                    boolean isConnected = true;
                    while(!st.isEmpty()){
                            int p = st.pop();
                            int c = map.get(p).size();
                            if((n-1) != c){
                                isConnected = false;
                                break;
                            }
                    }
                    if(isConnected) count++;

            }
        }
        return count;
    }

    private void dfs(int i, boolean[] vis,  ArrayList<ArrayList<Integer>> map, Stack<Integer> st) {
        vis[i] = true;
            for(int j : map.get(i)){
                if(!vis[j]) dfs(j,vis,map,st);
            }
        st.add(i);
    }
}
