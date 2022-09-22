// https://www.codechef.com/START57D/problems/NONNEGPROD

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
    int remove = 0;
    int isZero = 0;
    FOR(i, 0, n)
    {
        int num;
        cin >> num;
        if (num == 0)
            isZero = 1;
        if (num < 0)
            remove++;
    }
    if (remove % 2 == 0 || isZero)
        cout << "0";
    else
        cout << '1';
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