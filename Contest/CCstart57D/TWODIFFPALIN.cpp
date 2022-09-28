// https://www.codechef.com/START57D/problems/TWODIFFPALIN

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
    int zer0, on1;
    cin >> zer0 >> on1;
    if (zer0 == 0 || on1 == 0)
        cout << "NO";
    else if (zer0 == 1 || on1 == 1)
        cout << "NO";
    else if (zer0 % 2 != 0 && on1 % 2 != 0)
        cout << "NO";
    else
        cout << "YES";
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
    return 0;
}