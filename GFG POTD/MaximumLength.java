//https://practice.geeksforgeeks.org/problems/84963d7b5b84aa24f7807d86e672d0f97f41a4b5/1
import java.util.*;
public class MaximumLength {
    int solve(int a, int b, int c) {
        if(a > ((b+c)*2)+2)
            return -1;

        if(b > ((a+c)*2)+2)
            return -1;

        if(c > ((a+b)*2)+2)
            return -1;

        return a+b+c;
    }
}
