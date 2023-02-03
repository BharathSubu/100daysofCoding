//https://leetcode.com/problems/zigzag-conversion/

import java.util.*;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        HashMap<Integer,List<Character>> map = new HashMap<>();
        boolean down = true ;
        map.putIfAbsent(0,new ArrayList<>());
        map.get(0).add(s.charAt(0));
        int starti = 0;
        int i = 1;
        while(i<s.length()){
            if(down){
                for(int k = 1 ; k < numRows && i < s.length() ; k++){
                    starti++;
                    map.putIfAbsent(starti,new ArrayList<>());
                    map.get(starti).add(s.charAt(i));
                    i++;
                }
                down = false;
            }
            else{
                for(int k = 1 ; k < numRows && i < s.length() ; k++){
                    starti--;
                    map.putIfAbsent(starti,new ArrayList<>());
                    map.get(starti).add(s.charAt(i));
                    i++;
                }
                down = true;
            }
        }
        String res = "";
        for(i =0 ; i<numRows ; i++){
            if(map.containsKey(i))
            for(char c : map.get(i)){
                res+=c;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ZigzagConversion sol = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(sol.convert(s,numRows));
    }
}
