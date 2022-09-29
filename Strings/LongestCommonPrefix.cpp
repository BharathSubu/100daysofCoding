// https://leetcode.com/problems/longest-common-prefix/

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vs vector<string>
#define pb push_back
#define vvi vector<vector<int>>
#define umap unordered_map

string longestCommonPrefix(vector<string> &strs)
{
    int n = strs.size();
    if (n == 0)
        return "";
    if (n == 1)
        return strs[0];
    int end = INT_MAX;
    int pos = 0;
    FOR(i, 0, strs.size() - 1)
    {
        string s1 = strs[i], s2 = strs[i + 1];
        int x = 0, y = 0;
        pos = 0;
        while (x == y)
        {
            if (x > s1.size() - 1 || y > s2.size() - 1)
            {
                break;
            }
            if (s1[x] == s2[y])
            {
                pos++;
                x++;
                y++;
            }
            else
                break;
        }
        end = min(end, pos);
    }
    if (end == 0)
        return "";
    return strs[0].substr(0, end);
}
int main()
{
    vs s = {"dog", "racecar", "car"};
    cout << longestCommonPrefix(s);
}