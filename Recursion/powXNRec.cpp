// https://leetcode.com/problems/powx-n/

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

double myPow(double x, int n, double curr = 1)
{
    if (n < 0)
        flag = 1;
    n = abs(n);
    if (n == 0 && flag)
        return 1 / curr;
    else if (n == 0)
        return curr;
    curr *= x;
    return myPow(x, --n, curr);
}

int main()
{
    double x = 2.10000, n = -3;
    cout << myPow(x, n);
}