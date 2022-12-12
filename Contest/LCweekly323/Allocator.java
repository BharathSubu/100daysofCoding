// https://leetcode.com/contest/weekly-contest-323/problems/design-memory-allocator/

import java.util.*;


class Allocator {

    HashMap<Integer , Integer> map = new HashMap<>();
    int maxspace ;
    int spaceavilabel;
    List<Integer> lst;

    public Allocator(int n) {
        maxspace = n;
        spaceavilabel = 0;
        lst =  new ArrayList<>();
        
        for(int i = 0; i<n;i++) lst.add(-1);
    }
    
    public int allocate(int size, int mID) {
        spaceavilabel+=size;
        if(spaceavilabel > maxspace) {
            spaceavilabel-=size;
            return -1;
        }
        int start = 0, end = 0;
        int newsize = 0;
        for (int i = 0; i < lst.size(); i++) {
             newsize = size;
            if(lst.get(i).equals(-1)){
                start = i;
                end = i;
                while(i<lst.size() && lst.get(i)==-1){
                    if(newsize == 0) break;
                    end++;
                    i++;
                    newsize--;
                }
                
            }
            if(newsize == 0) break;
        }
        if(newsize != 0) return -1;
        
        for(int i = start; i <end ; i++){
                lst.set(i, mID);
                size--;
        }
        // map.put(mID, map.getOrDefault(mID, 0)+size);
        return start;
    }
    
    public int free(int mID) {
        int count = 0;
        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i).equals(mID) ){
                count++;
                spaceavilabel--;
                lst.set(i, -1);
            }
        }
        return count;
    }
}