// codechef.com/problems/KSUB

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
    int n, k;
    cin >> n >> k;
    vi arr(n);
    int g = 0;
    FOR(i, 0, n)
    {
        cin >> arr[i];
    }
    FOR(i, 0, n)
    {
        g = __gcd(g, arr[i]);
    }
    int count = 0;
    int curr = 0;
    FOR(i, 0, n)
    {
        curr = __gcd(curr, arr[i]);
        if (curr == g)
        {
            count++;
            curr = 0;
        }
    }
    if (count >= k)
        cout << "YES";
    else
        cout << "NO";
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}