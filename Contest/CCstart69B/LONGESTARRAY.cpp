// https://www.codechef.com/START69B/problems/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>

bool arrSame(vector<ll> a, vector<ll> b)
{

    FOR(i, 0, a.size())
    {
        if ((a[i] != 0 && b[i] == 0) || (a[i] == 0 && b[i] != 0))
            return 0;
    }

    return 1;
}

bool check(vector<ll> arr, vector<ll> ors, ll k)
{
    vector<ll> bits(32, 0);
    FOR(i, 0, k)
    for (int j = 30; j >= 0; j--)
    {
        if (arr[i] & (1LL << j))
        {
            bits[j]++;
            ors[j]--;
        }
    }

    if (arrSame(bits, ors))
        return 1;

    FOR(i, k, arr.size())
    {
        for (int j = 30; j >= 0; j--)
        {
            if (arr[i - k] & (1LL << j))
            {
                bits[j]--;
                ors[j]++;
            }
        }
        for (int j = 30; j >= 0; j--)
        {
            if (arr[i] & (1LL << j))
            {
                bits[j]++;
                ors[j]--;
            }
        }
        if (arrSame(bits, ors))
            return 1;
    }
    return 0;
}

void solve()
{
    ll n;
    cin >> n;
    vector<ll> arr(n);
    vector<ll> arrOR(32, 0);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    for (int i = 0; i < n; i++)
    {

        {
            for (int j = 30; j >= 0; j--)
            {
                if (arr[i] & (1LL << j))
                {
                    arrOR[j]++;
                }
            }
        }
    }
    ll l = 1, r = n, ans = -1;
    while (l <= r)
    {
        ll mid = (l + r) / 2;
        if (check(arr, arrOR, mid))
        {
            ans = max(ans, mid);
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    cout << ans;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}