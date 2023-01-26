//https://practice.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1

import java.util.*;

public class CaseSpecificSorting {

        //Function to perform case-specific sorting of strings.
        public static String caseSort(String s)
        {
            StringBuffer  ans =  new StringBuffer();
            int count = 0;
            char[]lst=s.toCharArray();
            Arrays.sort(lst);
            for(char c : s.toCharArray()){
                if(c >= 'A' && c<='Z') {
                    count++;
                }
            }
            int start =0;
            int start2 = count--;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    ans.append(lst[start++]);
                }
                else{
                    ans.append(lst[start2++]);
                }
            }
            return ans.toString();
        }
}
