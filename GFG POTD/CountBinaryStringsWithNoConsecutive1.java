//https://practice.geeksforgeeks.org/problems/37f36b318a7d99c81f17f0a54fc46b5ce06bbe8c/1
import java.util.*;
public class CountBinaryStringsWithNoConsecutive1 {
    int modulus = 1000000007;

    public int countStrings(long N) {
        return matrixPower(new int[][]{{1, 1}, {1, 0}}, N + 1)[0][0];
    }

    int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (int)((result[i][j] + (long)a[i][k] * b[k][j]) % modulus);   // Compute the (i, j)th entry of the product matrix
                }
            }
        }
        return result;
    }

    int[][] matrixPower(int[][] a, long n) {
        int[][] result = new int[][]{{1, 0}, {0, 1}};
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, a);
            }
            a = multiplyMatrices(a, a);
            n /= 2;
        }
        return result;
    }

}
