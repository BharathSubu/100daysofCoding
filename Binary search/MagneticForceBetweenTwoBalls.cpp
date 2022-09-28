// https://leetcode.com/problems/magnetic-force-between-two-balls/?envType=study-plan&id=binary-search-ii

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

bool isAllcoated(vi nums, ll balls, ll mid)
{
    ll n = nums.size();
    ll ballsplaced = balls - 1;
    ll start = nums[0];
    FOR(i, 1, n)
    {
        if (nums[i] - start >= mid)
        {
            ballsplaced--;
            start = nums[i];
        }
        if (ballsplaced == 0)
            return true;
    }
    return false;
}

ll maxDistance(vector<int> &position, ll m)
{
    sort(position.begin(), position.end());
    ll n = position.size();
    ll start = 1, end = position[n - 1] - start;
    ll res = end;
    while (start <= end)
    {
        ll mid = start + (end - start) / 2;
        if (isAllcoated(position, m, mid))
        {
            res = mid;
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return res;
}
int main()
{
    vi arr = {79, 74, 57, 22};
    ll maxmin = maxDistance(arr, 4);
    cout << maxmin;
};
