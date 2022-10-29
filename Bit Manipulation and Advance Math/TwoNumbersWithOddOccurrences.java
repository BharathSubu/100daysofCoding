//https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1
import java.util.Arrays;

public class TwoNumbersWithOddOccurrences {

    public static int[] twoOddNum(int arr[], int n)
    {
        int x = 0;
        for (int i = 0; i < n; i++) {
            x^=arr[i];
        }
        int set = x &(~(x-1));
        int first = 0 , second = 0;
        for (int i = 0; i < n; i++) {
            if((arr[i]&set) != 0){
                first^=arr[i];
            }
            else{
                second^=arr[i];
            }
        }
        if (first < second){
            first^=second;
            second^=first;
            first^=second;
        }
        int res [] = {first , second};
        return  res;
    }

    public static void main(String[] args) {
        int Arr[] = {4, 2, 4, 5, 2, 3, 3, 1};
        int res[] = twoOddNum(Arr,Arr.length);
        System.out.println(Arrays.toString(res));
    }
}
