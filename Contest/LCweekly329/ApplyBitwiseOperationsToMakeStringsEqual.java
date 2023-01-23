//https://leetcode.com/contest/weekly-contest-329/problems/apply-bitwise-operations-to-make-strings-equal/
import java.util.*;
public class ApplyBitwiseOperationsToMakeStringsEqual {
    public boolean makeStringsEqual(String s, String target) {
        if(s.length() != target.length()) return false;
        int count1S = 0;
        int count1T = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1')count1S++;
            if(target.charAt(i)=='1')count1T++;
        }
        if(count1S >0 && count1T == 0) return false;
        if(count1S == 0 && count1T > 0) return false;
        return true;
    }
}
