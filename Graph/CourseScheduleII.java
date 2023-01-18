// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

class CourseScheduleII {
    int idx = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

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
              dfs(i,map,courseNeeded, visted,res);
           }
        }
        if(idx == res.length)
        return res;
        else {
           int[] ans = new int[numCourses];
            return ans;
        }
    }
    void dfs(int i , HashMap<Integer, List<Integer>> map,  HashMap<Integer, Integer> courseNeeded  ,boolean []visted ,int [] res){
        visted[i] = true;
        res[idx] = i;
        idx++;
        if(map.containsKey(i))
        for (int j : map.get(i)) {
            courseNeeded.put(j, courseNeeded.getOrDefault(j, 0)-1);
            if(!visted[j] && courseNeeded.get(j) ==0 )
            dfs(j, map,courseNeeded, visted, res);
        }
    }
    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();
        int numCourses = 4 ; int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));
    }
}