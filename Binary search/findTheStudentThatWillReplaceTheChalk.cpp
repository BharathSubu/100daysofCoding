// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk

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

int chalkReplacer(vector<int> &chalk, ll k)
{
    ll n = chalk.size();
    vl presum(n);
    presum[0] = chalk[0];
    FOR(i, 1, n)
    {
        presum[i] = presum[i-1]+ chalk[i];
    }
    ll target = k % presum[n-1];
    ll start = 0, end = n - 1;
    ll pos = -1;
    if(target < presum[0]) return 0;

    while (start <= end)
    {
        ll mid = start + (end - start) / 2;
        if (presum[mid] == target)
        {
            pos = (mid == n - 1) ? 0 : mid + 1;
            return pos;
        }
        else if( presum[mid] > target) end = mid -1;
        else start = mid + 1; 
    }
    return start ;
}

int main()
{

    vi chalk = {5,1,5};
    ll k = 26;
    ll student = chalkReplacer(chalk, k);
    cout << student;
}
