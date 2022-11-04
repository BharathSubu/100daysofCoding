// https://leetcode.com/problems/longest-palindromic-substring/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vc vector<char>
#define pb push_back
#define vvi vector<vector<int>>

string longestPalindrome(string s)
{
    int n = s.size();
    int len = 0;
    string res = "";
    res += s[0];
    FOR(i, 0, n)
    {
        int j = i, k = i;
        while (j > -1 && k < n && s[j] == s[k])
        {
            if (len < k - j + 1)
            {
                res = s.substr(j, k - j + 1);
                len = k - j + 1;
            }
            j--;
            k++;
        }
        j = i, k = i + 1;
        while (j > -1 && k < n && s[j] == s[k])
        {
            if (len < k - j + 1)
            {
                res = s.substr(j, k - j + 1);
                len = k - j + 1;
            }
            j--;
            k++;
        }
    }
    return res;
}

int main()
{

    string s = "aaaa";
    cout << longestPalindrome(s);
}