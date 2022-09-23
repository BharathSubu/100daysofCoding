// https://www.codechef.com/submit/FARAWAY

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
    int n, m;
    cin >> n >> m;
    int arr[n];
    FOR(i, 0, n)
    cin >> arr[i];
    int numcenter = m / 2;
    int total = 0;
    FOR(i, 0, n)
    {
        if (arr[i] <= m / 2)
            total += abs(m - arr[i]);
        else
            total += abs(arr[i] - 1);
    }
    cout << total;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}