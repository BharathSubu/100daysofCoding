//https://leetcode.com/problems/happy-number/

class happyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(fast);
            fast = square(fast);

            if (slow == 1 || fast == 1)
                return true;
        } while (slow != fast);
        return false;
    }

    public int square(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            res += rem * rem;
            n = n / 10;
        }
        return res;
    }
}