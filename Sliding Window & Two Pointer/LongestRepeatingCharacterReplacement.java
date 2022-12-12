import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement/

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxCountOfRepeatingLetter = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char right = s.charAt(i);
            map.put(right, map.getOrDefault(right, 0)+1);
            maxCountOfRepeatingLetter = Math.max(maxCountOfRepeatingLetter, map.get(right));
            if(i-start+1-maxCountOfRepeatingLetter > k){
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                start++;
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}