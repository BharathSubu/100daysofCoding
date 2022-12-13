
import java.util.*;

class LongestSquareStreakinanArray {
  public int longestSquareStreak(int[] nums) {
    HashSet<Long> hashSet = new HashSet<>();
    for (int num : nums) {
      hashSet.add((long) num);
    }

    long longestStreak = 0;

    for (int num : nums) {
      if (!hashSet.contains(Math.sqrt(num))) {
        long currentNum = num;
        long currentStreak = 1;

        while (hashSet.contains(currentNum * currentNum)) {
          currentNum = currentNum * currentNum;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }
    if (longestStreak < 2)
      return -1;
    return (int) longestStreak;
  }

  public static void main(String[] args) {

    int arr[] = {};
    System.out.println(longestSquareStreak(arr));
  }
}