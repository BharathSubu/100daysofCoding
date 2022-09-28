// https://www.codechef.com/START58D/problems/ARRAYBREAK

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
    vi nums(n);
    int count = 0;
    FOR(i, 0, n)
    {
        cin >> nums[i];
        if (nums[i] % 2 == 0)
            count++;
    }
    cout << count;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
