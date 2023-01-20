//https://practice.geeksforgeeks.org/problems/230d87552a332a2970b2092451334a007f2b0eec/1
public class CarpetIntoBox {
    int carpetBox(int A, int B, int C, int D) {

        int move = 0;
        int move90 = 0;
        int l = A , b = B;
        while (l > A) {
            move++;
            l/=2;
        }
        while (b > B){
            move++;
            b/=2;
        }

        l = A ; b = B;
        while (l > B) {
            move90++;
            l/=2;
        }
        while (b > A){
            move90++;
            b/=2;
        }
        return Math.min(move,move90);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
