// https://leetcode.com/problems/split-array-largest-sum/submissions/
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

int allocation(vi nums, int N, int M, int mid)
{
    int sum = 0;
    int partition = 1;
    FOR(i, 0, N)
    {

        if (nums[i] > mid)
        {
            return M + 1;
        }
        if (sum + nums[i] > mid)
        {
            partition++;
            sum = nums[i];
        }
        else
        {

            sum += nums[i];
        }
    }
    return partition;
}

int splitArray(vector<int> &nums, int m)
{
    int N = nums.size();
    if (m == N)
    {
        int max = *max_element(nums.begin(), nums.end());
        return max;
    }
    if (m > N)
        return -1;
    int start = nums[0], end = 0;
    FOR(i, 0, N)
    {
        end += nums[i];
    }
    int minmax = nums[0];
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        // cout << mid << " " << allocation(A, N, M, mid);
        // nl;
        if (allocation(nums, N, m, mid) <= m)
        {
            minmax = mid;
            end = mid - 1;
        }
        else if (allocation(nums, N, m, mid) > m)
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return minmax;
}

int main()
{

    vi arr = {11, 16, 19, 55, 60, 71, 76, 80, 88, 90, 90};
    ll minmax = splitArray(arr, 11);
    cout << minmax;
};
