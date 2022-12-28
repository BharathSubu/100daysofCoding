//https://leetcode.com/problems/valid-parenthesis-string/description/
//sol ref :- https://leetcode.com/problems/valid-parenthesis-string/solutions/532433/greedy-w-counter-one-pass-o-n/?topicTags=greedy
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int cnt = 0;
        int star = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            }
            else if (c == ')') {
                cnt--;
                if (cnt < 0) {
                    if (star == 0)
                        return false;

                    cnt++;
                    star--;
                }
            }
            else {
                if (cnt > 0) {
                    cnt--;
                    star += 2;
                } else {
                    star++;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("((*)"));
    }
}
