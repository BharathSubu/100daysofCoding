// https://www.codechef.com/START58D/problems/RANKLISTPAGE

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
    int n;
    cin >> n;
    if (n % 25 == 0)
        cout << n / 25;
    else
        cout << n / 25 + 1;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
