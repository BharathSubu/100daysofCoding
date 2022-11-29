//https://leetcode.com/problems/insert-delete-getrandom-o1/description/

import  java.util.*;

class InsertDeleteGetRandom {

    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    java.util.Random rand = new java.util.Random();

    public InsertDeleteGetRandom() {
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else{
            arr.add(val);
            map.put(val, arr.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int v = arr.get(arr.size() - 1);
            arr.set(index, v);
            arr.remove(arr.size() - 1);
            map.put(v, index);
            map.remove(val);
            return true;
        }
        else return false;
    }
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
