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
    unordered_map<ll, ll> map;
    map[0] = 0;
    map[1] = 0;
    map[2] = 0;
    for (ll i = 0; i < n; i++)
    {
        ll num;
        cin >> num;
        num = num % 3;
        // cout << num << " ";
        map[num]++;
    }
    if (map[0] == n)
    {
        cout << "0\n";
        return;
    }
    if (map[1] == map[2])
    {
        cout << map[1];
        nl;
        return;
    }
    ll count = 0;
    while (map[1] != 0 && map[2] != 0)
    {
        map[1]--;
        map[2]--;
        count++;
    }
    if (map[2] == 0)
    {
        ll needone = 4 - map[1] % 4;
        if (needone == 4)
        {
            map[1] /= 4;
            count += (map[1] * 3);
        }
        else
        {
            // cout << count << " " << needone;
            // nl;
            count += needone;
            map[1] += needone;
            map[1] /= 4;
            count += (map[1] * 3);
        }
    }
    else
    {
        ll needone = 4 - map[2] % 4;
        if (needone == 4)
        {
            map[2] /= 4;
            count += (map[2] * 3);
        }
        else
        {
            // cout << count << " " << needone;
            // nl;
            count += needone;
            map[2] += needone;
            map[2] /= 4;
            count += (map[2] * 3);
        }
    }
    cout << count;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}