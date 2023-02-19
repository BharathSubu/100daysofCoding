//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        if(low%2 == 0)
            low += 1;
        if(high%2 == 0)
            high -= 1;
        return (high - low)/2 + 1;
    }
}
