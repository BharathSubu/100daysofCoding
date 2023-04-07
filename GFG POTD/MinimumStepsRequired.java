//https://practice.geeksforgeeks.org/problems/6a1b365b520f10c8a29b533eb72951b4b4237b57/1
import java.util.*;
public class MinimumStepsRequired {
    int minSteps(String str) {
        int aC=0 , bC = 0;
        char prev='#';
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(prev==ch) continue;
            if(ch=='a') aC++;
            else bC++;
            prev=ch;
        }
        return Math.min(aC,bC)+1;
    }
}
