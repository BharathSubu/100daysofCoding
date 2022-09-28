// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

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

bool isAllcoated(vi nums, int maxOperation, int mid)
{
    int n = nums.size();
    int step = 0;
    FOR(i, 0, n)
    {
        if (nums[i] > mid)
        {
            if (nums[i] % mid != 0)
            {
                step += nums[i] / mid;
            }
            else
            {
                step += nums[i] / mid - 1;
            }
        }
    }

    if (step <= maxOperation)
        return true;
    return false;
}

int minimumSize(vector<int> &nums, int maxOperations)
{
    int start = 1, end = *max_element(nums.begin(), nums.end());
    int res = end;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (isAllcoated(nums, maxOperations, mid))
        {

            res = mid;
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return res;
}

int main()
{
    vi arr = {7, 17};
    ll maxmin = minimumSize(arr, 2);
    cout << maxmin;
};
