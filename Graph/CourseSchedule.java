// https://leetcode.com/problems/course-schedule/description/

import java.util.*;

class CourseSchedule {
    
    int idx = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       

        boolean isParent[] = new boolean[numCourses];
        Arrays.fill(isParent, true);

        boolean visted[] = new boolean[numCourses];
        Arrays.fill(visted, false);

        //ploting graph and finding parent node , that is node without zero incoming nodes
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //count of course needed
        HashMap<Integer, Integer> courseNeeded = new HashMap<>();

        for (int [] p : prerequisites) {
            int child = p[0];
            int parent = p[1];
            isParent[child] = false;
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(child);
            courseNeeded.put(child, courseNeeded.getOrDefault(child, 0)+1);
        }
        
        for (int i = 0; i < isParent.length; i++) {
           if(isParent[i]){
              dfs(i,map,courseNeeded, visted);
           }
        }
        if(idx == numCourses)
        return true;
        else {
            return false;
        }
    }
    void dfs(int i , HashMap<Integer, List<Integer>> map,  HashMap<Integer, Integer> courseNeeded  ,boolean []visted ){
        visted[i] = true;
        idx++;
        if(map.containsKey(i))
        for (int j : map.get(i)) {
            courseNeeded.put(j, courseNeeded.getOrDefault(j, 0)-1);
            if(!visted[j] && courseNeeded.get(j) ==0 )
            dfs(j, map,courseNeeded, visted);
        }
    }
    
}