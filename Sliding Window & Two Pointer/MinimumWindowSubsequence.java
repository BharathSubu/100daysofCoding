//https://practice.geeksforgeeks.org/problems/minimum-window-subsequence/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-window-subsequence
import java.util.*;

public class MinimumWindowSubsequence {
    static String minWindow(String S, String T) {
        String window = "";
        int j = 0, min = S.length() + 1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                if (j == T.length()) {
                    int end = i + 1;
                    j--;
                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) j--;
                        i--;
                    }
                    j++;
                    i++;
                    if (end - i < min) {
                        min = end - i;
                        window = S.substring(i, end);
                    }
                }
            }
        }
        return window;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ofxdhbznclikrrpcmrgosmzqgdpmbhsnefasbfgylvfnbswamixovogwouiywhfptduxtiuwcbwhzloqpqssnwmytfythacyqonsaobbfoxioywgwwkhaofbmvomvnkhzytthljwwlicbaaynysltk","xvgoiwftutucwzop"));

    }
}
