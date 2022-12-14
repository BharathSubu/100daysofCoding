// https://www.codechef.com/START69B/problems/CHEFDINE

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
    ll n, k;
    cin >> n >> k;
    int a[n], b[n];
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> b[i];
    }
    unordered_map<int, vi> map;
    for (int i = 0; i < n; i++)
    {
        map[a[i]].push_back(b[i]);
    }
    if (map.size() < k)
    {
        cout << "-1\n";
        return;
    }

    vi res;
    for (auto i : map)
    {
        res.push_back(*min_element(i.second.begin(), i.second.end()));
    }
    sort(res.begin(), res.end());
    ll ans = 0;
    for (int i = 0; i < k; i++)
    {
        ans += res[i];
    }
    cout << ans;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}