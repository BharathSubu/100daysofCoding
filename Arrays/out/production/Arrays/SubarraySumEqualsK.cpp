// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int subarraySum(vector<int> &nums, int k)
{
    unordered_map<int, int> visited;
    int presum = 0;
    int count = 0;
    FOR(i, 0, nums.size())
    {
        presum += nums[i];

        if (presum == k)
            count++;
        int h = presum - k;
        if (visited.find(h) != visited.end())
        {
            count += visited[h];
        }
        visited[presum]++;
    }
    return count;
}

int main()
{
    vi nums = {-3, -2, -1, 0, 0, 1, 1, 3};
    int total;
    total = subarraySum(nums, 2);

    cout << total;
}