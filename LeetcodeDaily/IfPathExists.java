
import java.util.*;

class IfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int[] is : edges) {
            map.putIfAbsent(is[0], new ArrayList<>());
            map.get(is[0]).add(is[1]);
            map.putIfAbsent(is[1], new ArrayList<>());
            map.get(is[1]).add(is[0]);
        }
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);
        Queue<Integer> qu = new LinkedList<>();
        if(map.size() == 0) return true;
        for (Integer i : map.get(source)) {
            qu.add(i);
        }
        visited[source] = true;
        while(!qu.isEmpty()){
            if(qu.peek() == destination) return true;
            int curr = qu.poll();
            visited[curr] = true;
            for (Integer i : map.get(curr)) {
                if(!visited[i])
                qu.add(i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        IfPathExists sol = new IfPathExists();
        int n = 9; int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}} ; int source = 5, destination = 9 ;
        System.out.println(sol.validPath(n, edges, source, destination));
    }
}