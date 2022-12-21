// https://leetcode.com/problems/keys-and-rooms/

import java.util.*;

class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);
        Queue<Integer> qu = new LinkedList<>();
        if(rooms.size() == 0) return true;
        for (Integer i : rooms.get(0)) {
            qu.add(i);
        }
        visited[0] = true;
        while(!qu.isEmpty()){
            int curr = qu.poll();
            visited[curr] = true;
            for (Integer i : rooms.get(curr)) {
                if(!visited[i])
                qu.add(i);
            }
        }
        for (boolean i : visited) {
            if(!i)return false;
        }
        return true;
    }
}