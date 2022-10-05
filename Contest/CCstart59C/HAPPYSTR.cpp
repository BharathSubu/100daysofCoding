// https://www.codechef.com/START59C/problems/HAPPYSTR

#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>
#define pb push_back

void solve()
{
    string s;
    cin >> s;
    int n = s.length();
    int count = 0;

    vi arr(26, 0);
    arr['a' - 'a'] = 1;
    arr['e' - 'a'] = 1;
    arr['i' - 'a'] = 1;
    arr['o' - 'a'] = 1;
    arr['u' - 'a'] = 1;

    FOR(i, 0, n)
    {
        if (arr[s[i] - 'a'] == 1)
            count++;
        else
            count = 0;
        if (count > 2)
        {
            cout << "HAPPY\n";
            return;
        }
    }
    cout << "SAD\n";
    return;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
