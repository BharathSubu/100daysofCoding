// https://www.codechef.com/START58D/problems/REACHTARGET

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

void solve()
{
    int a, b;
    cin >> a >> b;
    cout << a - b;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
