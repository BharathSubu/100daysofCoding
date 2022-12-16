// https://www.codechef.com/START69B/problems/DIVBYTHREE

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
    ll n;
    cin >> n;
    int cnt[3] = {0};
    vi a(n);
    for (auto &e : a)
    {
        cin >> e, e %= 3;
        cnt[e]++;
    }
    if (cnt[1] > cnt[2])
    {
        int temp = cnt[2];
        cnt[2] = cnt[1];
        cnt[1] = temp;
    }
    int ops = 0;
    while (cnt[2] - cnt[1] > 2)
    {
        cnt[2] -= 2;
        cnt[1] += 2;
        ops++;
    }
    if (cnt[1] > cnt[2])
    {
        int temp = cnt[2];
        cnt[2] = cnt[1];
        cnt[1] = temp;
    }
    ops += cnt[1];
    if (cnt[2] == cnt[1] + 1)
    {
        if ((cnt[1] == 1 && cnt[0] != 0) || cnt[1] > 1)
            ops += 2;
        else
            ops += 6;
    }
    else if (cnt[2] == cnt[1] + 1)
    {
        if ((cnt[1] == 1 && cnt[0] != 0) || cnt[1] > 1)
            ops += 4;
        else
            ops += 5;
    }
    cout << ops;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}