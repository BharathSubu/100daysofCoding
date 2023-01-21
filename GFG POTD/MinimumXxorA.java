// https://practice.geeksforgeeks.org/problems/1fc4278adf2a36780f637c7b4cd06391dd1487e4/1

class MinimumXxorA {
    public static int minVal(int A, int B) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((B & 1 << i) != 0)
                count++;
        }
        int x = 0, i = 0;
        for (i = 31; i >= 0; i--) {
            if (count == 0) {
                break;
            }
            if ((A & 1 << i) != 0) {
                x = x | 1 << i;
                count--;
            }
        }
        if (count != 0) {
            for (int j = 0; j < 32; j++) {
                if (count == 0) {
                    break;
                }
                if((x & 1 << j) == 0)
                {
                    x = x | 1 << j;
                    count--;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int a = 5, b = 13;
        System.out.println(minVal(a, b));
    }
}