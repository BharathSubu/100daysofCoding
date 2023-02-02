//https://practice.geeksforgeeks.org/problems/fda70097eb2895ecfff269849b6a8aace441947c/1
public class MinimumTimesAHasToBeRepeatedSuchThatBIsASubstringOfIt {
    static int minRepeats(String A, String B) {
        int m = A.length();
        int n = B.length();
        int count = 0;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            int k = 0;
            int j  = i;
            count = 1;
            while (k<n && (A.charAt(j) == B.charAt(k))){
                if (k == n - 1) {
                    found = true;
                    break;
                }
                j = (j+1)%m;
                k++;
                if(j==0) count++;
            }
            if(found) return count;
        }
        return -1;
    }
}
