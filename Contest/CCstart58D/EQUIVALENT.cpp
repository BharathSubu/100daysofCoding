// https://www.codechef.com/START58D/problems/EQUIVALENT

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

// wrong

void solve()
{
    ll a, b;
    cin >> a >> b;
    if (a == b)
    {
        cout << "YES";
        nl;
        return;
    }
    ll maxnum = a > b ? a : b;
    ll minum = a < b ? a : b;
    float num = minum;
    int part = (int)num;
    int base = 1;

    int start = 1, end = minum / 2;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        float num =
    }

    cout << log(maxnum) / log(minum);
    cout << log(minum) / log(minum);

    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
