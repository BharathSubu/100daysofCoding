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
    float num = 1.0f;
    int part = (int)num;
    int base = 1;
    while ((num - part) == 0)
    {
        base = part;
        num = sqrt(num);
        part = (int)num;
        cout << base;
    }
    cout << base;

    ll maxnum = a > b ? a : b;
    ll minum = a < b ? a : b;
    cout << log(maxnum) / log(2);
    cout << log(minum) / log(2);

    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
