// https://www.codechef.com/START57D/problems/EVENSPLIT

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void solve()
{
    int n;
    cin >> n;
    string s;
    cin >> s;
    sort(s.begin(), s.end(), greater<int>());
    string num = "", op = "";
    FOR(i, 0, n)
    {
        if (s[i] >= 48)
            num += s[i];
        else
            op += s[i];
    }
    sort(op.begin(), op.end());
    string res = "";
    int k = num.size() - op.size();
    int x = 0;
    FOR(i, 0, k)
    {
        res += num[i];
    }
    int i = 0, j = 1;
    while (k < num.size() || x < op.size())
    {
        if (j)
        {
            j = 0;
            res += op[x];
            x++;
        }
        else
        {
            j = 1;
            res += num[k];
            k++;
        }
    }
    cout << res;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }

    return 0;
}