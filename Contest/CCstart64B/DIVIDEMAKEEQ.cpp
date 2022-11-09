// https://www.codechef.com/START64B/problems/DIVIDEMAKEEQ
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
    ll n;
    cin >> n;
    vi nums(n);
    FOR(i, 0, n)
    cin >> nums[i];
    int gcd = nums[0];
    for (int i = 0; i < n; i++)
    {
        gcd = __gcd(nums[i], gcd);
        if (gcd == 1)
            break;
    }
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] / gcd != 1)
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
}