// Implement Pow(x,n) | X raised to the power N
// Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).

// Examples:

// Example 1:

// Input: x = 2.00000, n = 10

// Output: 1024.00000

// Explanation: You need to calculate 2.00000 raised to 10 which gives ans 1024.00000

// Example 2:

// Input: x = 2.10000, n = 3

// Output: 9.26100

// Explanation: You need to calculate 2.10000 raised to 3 which gives ans 9.26100

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vd vector<double>
#define vvi vector<vector<int>>

double power(double x, ll n, vd &value)
{
    if (n == 1)
        return x;
    if (value[n] == -1)
    {
        if (n % 2 == 0)
        {
            value[n] = power(x, n / 2, value) * power(x, n / 2, value);
        }
        else
        {
            value[n] = power(x, n - 1, value) * x;
        }
        return value[n];
    }
    else
        return value[n];
}

void solve()
{
    double x = 0.00001;
    ll n = 2147483647;
    ll size = abs(n) + 1;
    vd value(size, -1);
    value[0] = 1;
    double res = power(x, abs(n), value);
    if (n < 0)
        cout << 1 / res;
    else
        cout << res;
}

int main()
{
    solve();
}