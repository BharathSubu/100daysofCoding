
// https://www.codechef.com/submit/NEARESTEXIT

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
    if (n > 50)
        cout << "RIGHT";
    else
        cout << "LEFT";
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}