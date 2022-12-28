import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-325/problems/shortest-distance-to-target-string-in-a-circular-array/
import java.util.*;
class ShortestDistanceInACircularArray {
    public static int closetTarget(String[] words, String target, int startIndex) {
        int res = -1;
        if(words[startIndex] == target) return 0;
        List<String> array = new ArrayList<>(Arrays.asList(words));
        for (String string : words) {
            array.add(string);
        }
        for (int i = startIndex; i < array.size(); i++) {
            if(array.get(i).equals(target)) {
                res = Math.abs(i -startIndex);
                break;
            }
           
        }
        int nexti = startIndex + words.length;
        for(int i = nexti ; i >= 0 ; i--){
            if(array.get(i).equals(target)) {
                res = Math.min(nexti - i, res);
                break;
            }
        } 
        return res;
    }
    public static void main(String[] args) {
        String arr[] ={"hello","i","am","leetcode","bb"};
        String s= "bb";
        int start =1;
        System.out.println(closetTarget(arr, s, start));
    }
}