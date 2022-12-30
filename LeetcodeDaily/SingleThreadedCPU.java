//https://leetcode.com/problems/single-threaded-cpu/description/

import java.util.*;

public class SingleThreadedCPU {

        public int[] getOrder(int[][] tasks) {


            PriorityQueue<int[]> p = new PriorityQueue<>( new Comparator<int[]>() {
                @Override
                public int compare(final int[] entry1,
                                   final int[] entry2) {

                    if (entry1[0] > entry2[0])
                        return 1;
                    else
                        return -1;
                }
            });
            int[][] newtasks = new int[tasks.length][3];
            int len = 0;
            for (int [] task:tasks) {
                newtasks[len][0] = task[0];
                newtasks[len][1] = task[1];
                newtasks[len][2] = len;
                len++;
            }
            Arrays.sort(newtasks,(first,second)->first[0] - second[0]);
            int i = 0 , time = newtasks[0][0] ;
            int res[] = new int[tasks.length];
            len = 0;
            while(i< tasks.length || !p.isEmpty()){
                while(i< tasks.length && time >=newtasks[i][0]) {
                    int r[] = {newtasks[i][1] , newtasks[i][2]} ;
                    p.add(r);
                    i++;
                }
                if(p.isEmpty()){
                    time = tasks[i][0];
                }
                else{
                    int r[] = p.poll();
                    int pTime = r[0];
                    int idx = r[1];
                    time+=pTime;
                    res[len++] = idx;
                }
            }
            return  res;
        }

}
