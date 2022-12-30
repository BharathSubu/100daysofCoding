//https://practice.geeksforgeeks.org/problems/introduction-to-trees/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-trees
public class IntroductiontoTrees {
    static int countNodes(int i) {
        double ans = Math.pow(2,i-1);
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(countNodes(5));
    }
}
