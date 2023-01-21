// https://leetcode.com/problems/restore-ip-addresses/

import java.util.*;

class RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s){
        HashSet<String> set =  new HashSet<>();
        for (int i = 0; i <= 255; i++) {
            set.add(Integer.toString(i));
        }
        findIp(0, 1,"",s,set);
        return res;
    }

    void findIp(int i , int step ,String sol, String s, HashSet<String> set ){

        if(i >= s.length()) return;
        if(step == 4){
            sol+=s.substring(i,s.length());
            if(validate(sol, set)) {
                res.add(new String(sol));
            }
            return;
        }
        for (int j = i; j < s.length() && j < i+3; j++) {
            int sub = j-i;
            String n = new String(sol);
            n+=s.substring(i, i+sub+1);
            // System.out.println(sol);
            n+=".";
            findIp(j+1, step+1, n, s, set);
        }
    }

    boolean validate(String s , HashSet<String> set ){
        String[] str=s.split("[.]",0);
        for (String string : str) {
            if(!set.contains(string)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "101023";
        RestoreIPAddresses sol = new RestoreIPAddresses();
        System.out.println(sol.restoreIpAddresses(s));
    }
}