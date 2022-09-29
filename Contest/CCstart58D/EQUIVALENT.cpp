// https://www.codechef.com/START58D/problems/EQUIVALENT
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
#define pb push_back

vi primes(1e6 + 1, 1);
vi prime;
void seive()
{
    primes[0] = primes[1] = 0;
    for (int i = 2; i * i <= 1e6; i++)
    {
        if (primes[i])
        {
            prime.pb(i);
            for (int j = i * i; j <= 1e6; j += i)
            {
                primes[j] = 0;
            }
        }
    }
    for (int i = 1e3 + 1; i < 1e6; i++)
    {
        if (primes[i])
            prime.pb(i);
    }
}

vector<pair<int, int>> factors(int n)
{
    vector<pair<int, int>> fac;
    int m = n;
    for (int i = 0; i < prime.size() && prime[i] * prime[i] <= n; i++)
    {
        int count = 0;
        int x = prime[i];
        while (n % x == 0)
        {
            count++;
            n /= x;
        }
        if (count > 0)
        {
            fac.pb({x, count});
        }
    }
    if (n > 1)
        fac.pb({n, 1});
    return fac;
}

void solve(int a, int b)
{

    vector<pair<int, int>> fac_a = factors(a);
    vector<pair<int, int>> fac_b = factors(b);
    int n = fac_a.size(), m = fac_b.size();
    if (n != m)
    {
        cout << "NO";
        nl;
        return;
    }
    bool flag = 1;
    set<pair<int, int>> rat;
    FOR(i, 0, n)
    {
        if (fac_a[i].first != fac_b[i].first)
        {
            flag = 0;
            break;
        }
        int x = fac_a[i].second, y = fac_b[i].second;
        int gcd = __gcd(x, y);
        x /= gcd;
        y /= gcd;

        rat.insert({x, y});
    }
    if (flag && rat.size() == 1)
    {
        cout << "YES";
    }
    else
        cout << "NO";
    nl;
}

int main()
{
    seive();
    int t;
    cin >> t;
    while (t--)
    {
        int a, b;
        cin >> a >> b;
        if (a > b)
            solve(a, b);
        else
            solve(b, a);
    }
};
