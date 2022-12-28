// https://www.codechef.com/START71B/problems/PETSTORE

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
    int n;
    cin >> n;
    unordered_map<int, int> map;
    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;
        map[num]++;
    }
    for (auto const &[key, value] : map)
    {
        if (value % 2 != 0)
        {
            cout << "NO\n";
            return;
        }
    }
    cout << "YES\n";
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}