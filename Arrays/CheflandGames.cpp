
// https://www.codechef.com/submit/CHEFGAMES

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
    vi arr(4);
    FOR(i, 0, 4)
    cin >> arr[i];
    int sum = 0;
    FOR(i, 0, 4)
    sum += arr[i];
    if (sum == 0)
        cout << "IN";
    else
        cout << "OUT";
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}