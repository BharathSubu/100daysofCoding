// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int lengthOfLongestSubstring(string s)
{
    if (s.length() == 0)
        return 0;
    int maxlen = 0;
    int count = 0;
    vi index(256, -1);
    int i = 0, j = 0;

    while (j < s.length())
    {
        if (index[s[j]] != -1)
            i = max(index[s[j]] + 1, i);
        index[s[j]] = j;
        maxlen = max(j - i + 1, maxlen);
        j++;
    }

    return maxlen;
}

int main()
{
    string s = "pwwkew";
    int len;
    len = lengthOfLongestSubstring(s);
    cout << len;
}