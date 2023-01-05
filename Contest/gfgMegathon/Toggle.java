import java.util.Arrays;

//https://practice.geeksforgeeks.org/contest/mega-job-a-thon-hiring-challenge-for-freshers/problems/
public class Toggle {

    public static int toggle(int n, int[] nums) {
      int prevOnes = 0;
      int numberofOnes = 0;
      int numberOfZeros = 0;
      int nextOnes =0;
      int j = 0;

      for (j = 0; j <n ;) {
          while (j < n && nums[j] == 1){
              j++;
              prevOnes++;
          }
          while (j<n&& nums[j] == 0){
              numberOfZeros++;
              j++;
          }
          while (j<n && nums[j] == 1){
              j++;
              nextOnes++;
          }
          int currlen = prevOnes+numberOfZeros+nextOnes;
          numberofOnes = Math.max(numberofOnes,currlen);
          prevOnes =nextOnes;
          numberOfZeros = 0;
          nextOnes = 0;
      }
      return numberofOnes;
    }

    public static void main(String[] args) {
        int [] arr = {1, 0 ,1 ,0, 0 ,1, 1 ,1 ,0 ,0};
        System.out.println(toggle(arr.length,arr));
    }
}
