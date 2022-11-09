// https://www.codechef.com/START64B/problems/PRIMEFACDIV

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

ll MAXN = pow(10, 8);
vi spf(MAXN);
void sieve()
{
    spf[1] = 1;
    for (ll i = 2; i < MAXN; i++)
        spf[i] = i;
    for (ll i = 4; i < MAXN; i += 2)
        spf[i] = 2;

    for (ll i = 3; i * i < MAXN; i++)
    {
        if (spf[i] == i)
        {
            for (ll j = i * i; j < MAXN; j += i)
                if (spf[j] == j)
                    spf[j] = i;
        }
    }
}

bool getFactorization(ll x, ll a)
{

    while (x != 1)
    {
        if (a % spf[x] != 0)
            return false;
        x = x / spf[x];
    }
    return true;
}
void solve()
{
    ll a, b;
    cin >> a >> b;
    int gcd = __gcd(a, b);
    if (gcd == a)
    {
        cout << "YES";
        nl;
        return;
    }
    else
    {
        cout << "NO";
        nl;
        return;
    }
    if (getFactorization(b, a))
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }
    nl;
    return;
}

int main()
{
    sieve();
    ll t;
    cin >> t;
    while (t--)
        solve();
}