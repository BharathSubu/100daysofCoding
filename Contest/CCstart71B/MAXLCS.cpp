// https://www.codechef.com/START71B/problems/MAXLCS

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void solve()
{
}

int findLCM(String text1, String text2, int id1, int id2, int[][] dp)
{
    if (id1 < 0 || id2 < 0)
        return 0;
    if (dp[id1][id2] != -1)
        return dp[id1][id2];
    if (text1.charAt(id1) == (text2.charAt(id2)))
    {
        dp[id1][id2] = 1 + findLCM(text1, text2, id1 - 1, id2 - 1, dp);
        return dp[id1][id2];
    }
    dp[id1][id2] = Math.max(findLCM(text1, text2, id1, id2 - 1, dp), findLCM(text1, text2, id1 - 1, id2, dp));
    return dp[id1][id2];
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}