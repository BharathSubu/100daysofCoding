
public class CountStrings {

    long count = 0;

    public long countStrings(int n) {
        countStrings(n, 0, 0);
        return count;
    }

    public void countStrings(int n, int prev, int i) {
        if (i == n) {
            count++;
            return;
        }
        countStrings(n, 0, i + 1);
        if (prev != 1)
            countStrings(n, 1, i + 1);
        return;
    }

    public static void main(String[] args) {
        CountStrings sol = new CountStrings();
        long cou = sol.countStrings(2);
        System.out.println(cou);
    }
}
