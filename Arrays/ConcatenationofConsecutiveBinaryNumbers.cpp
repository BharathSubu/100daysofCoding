// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int concatenatedBinary(int n)
{
    ll res = 1;
    ll i = 2;
    int mod = pow(10, 9) + 7;

    while (i <= n)
    {
        ll power = log2(i) + 1;

        res = (res * pow(2, power) + i);
        res = res % mod;
        i++;
    }
    return res;
}

int main()
{
    int n = 12;
    cout << concatenatedBinary(n);
}