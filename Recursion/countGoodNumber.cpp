// https://leetcode.com/problems/count-good-numbers/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int flag = 0;
int mod = pow(10, 9) + 7;

// recursion
ll binpowrec(ll x, ll n, ll m, ll curr = 1)
{

    if (n == 0)
        return curr % m;
    if (n & 1)
    {
        ll res = binpowrec(x, --n, m, curr);
        res = (x * res % m) % m;
        return res;
    }
    else
    {
        ll res = binpowrec(x, n / 2, m, curr);
        res = (res * res) % m;
        return res;
    }
}

// iterative
ll binpow(long long a, long long b, long long m)
{
    a %= m;
    long long res = 1;
    while (b > 0)
    {
        if (b & 1)
            res = res * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return res;
}

int countGoodNumbers(long long n)
{
    ll pow5 = binpowrec(5, n / 2 + n % 2, mod);
    ll pow4 = binpowrec(4, n / 2, mod);
    ll res = (pow5 * pow4) % mod;
    return res;
}

int main()
{
    cout << countGoodNumbers(50);
}