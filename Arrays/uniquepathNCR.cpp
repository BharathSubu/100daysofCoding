// https://leetcode.com/problems/unique-paths/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int comb(int n, int r)
{
    if (r == 0)
        return 1;
    if (n - r < r)
        r = n - r;
    ll p = 1, k = 1;

    while (r)
    {

        p = p * n;
        k = k * r;
        ll m = __gcd(p, k);
        p /= m;
        k /= m;
        n--;
        r--;
    }
    return p;
}

int uniquePaths(int m, int n)
{
    return comb(n + m - 2, m - 1);
}
int main()
{
    cout << uniquePaths(3, 7);
}