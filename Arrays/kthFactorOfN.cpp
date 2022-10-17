// https://leetcode.com/problems/the-kth-factor-of-n/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int kthFactor(int n, int k)
{
    int count = 0;
    FOR(i, 1, n + 1)
    {
        if (n % i == 0)
            count++;
        if (count == k)
            return i;
    }
    return -1;
}
int main()
{
    cout << kthFactor(12, 3);
}