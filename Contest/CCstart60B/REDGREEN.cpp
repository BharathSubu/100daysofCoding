// https://www.codechef.com/submit/REDGREEN
// upsolve
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

const ll modd = 998244353;
ll fact[2005];
void factorial(ll n)
{
    fact[0] = 1;
    FOR(i, 1, n + 1)
    {
        fact[i] = (i * fact[i - 1]) % modd;
    }
}

ll power(ll a, ll n, ll modd)
{
    a = a % modd;
    ll res = 1;
    while (n)
    {
        if (n & 1)
            res = (res * a) % modd;
        n >>= 1;
        a = (a * a) % modd;
    }
    return res;
}

ll modulo_inverse(ll n, ll p)
{
    ll res = power(n, p - 2, p);
    return res;
}

ll comb(ll n, ll r, ll p)
{
    if (r > n)
        return 0;
    else if (r == 0)
        return 1;
    return (fact[n] * (modulo_inverse(fact[r], p) % p) * (modulo_inverse(fact[n - r], p) % p));
}

void solve()
{
    ll n, m;
    cin >> n >> m;
    ll total = n + m - 1;
    if (total % 2 != 0)
    {
        cout << "0";
        nl;
        return;
    }

    ll ways = comb(total, total / 2, modd);
    ll paths = comb(n + m - 2, n - 1, modd);
    ll ans = (ways * paths) % modd;
    cout << ans;
    nl;
}

int main()
{
    factorial(2004);
    ll t;
    cin >> t;
    while (t--)
    {
        solve();
    }
}