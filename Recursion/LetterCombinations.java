
import java.util.*;

public class LetterCombinations {

    List<String> res = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    StringBuilder resultString = new StringBuilder("");

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations(digits, 0, 0);
        return res;
    }

    void letterCombinations(String digits, int i, int len) {

        if (len == digits.length()) {
            res.add(resultString.toString());
            return;
        }
        // if()
        for (int j = i; j < digits.length(); j++) {
            String str = map.get(digits.charAt(j));
            // System.out.println(str);
            for (int k = 0; k < str.length(); k++) {
                resultString.append(str.charAt(k));
                letterCombinations(digits, j + 1, len + 1);
                resultString.deleteCharAt(resultString.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

        LetterCombinations sol = new LetterCombinations();
        List<String> res = sol.letterCombinations("23");
        System.out.println(res);

    }
}
