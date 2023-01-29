//https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/

import java.util.*;

public class DataStreamAsDisjointIntervals {
    TreeSet<Integer> tree;
    public DataStreamAsDisjointIntervals() {
        tree = new TreeSet();
    }

    public void addNum(int value) {
        tree.add(value);
    }

    public int[][] getIntervals() {
        ArrayList<int[]> interval = new ArrayList();
        int start = tree.first();
        int end = tree.first();
        for(int value : tree.tailSet(tree.first()+1)){
            if(value-end==1){
                end = value;
            }else{
                int [] arr = new int[2];
                arr[0]=start;
                arr[1]=end;
                interval.add(arr);
                start = value;
                end = value;
            }
        }
        int [] arr = new int[2];
        arr[0]=start;
        arr[1]=end;
        interval.add(arr);
        return interval.toArray(new int[interval.size()][]);
    }
}
