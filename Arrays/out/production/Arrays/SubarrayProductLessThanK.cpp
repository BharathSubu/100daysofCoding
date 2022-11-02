// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
// Example 1:

// Input: nums = [10,5,2,6], k = 100
// Output: 8
// Explanation: The 8 subarrays that have product less than 100 are:
// [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
// Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
// Example 2:

// Input: nums = [1,2,3], k = 0
// Output: 0

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int numSubarrayProductLessThanK(vector<int> &nums, int k)
{
    int premul = 1;

    int start = 0;
    int count = 0;
    FOR(i, 0, nums.size())
    {
        premul *= nums[i];

        while (start < i && premul >= k)
        {
            premul /= nums[start++];
        }
        if (premul < k)
        {
            int len = i - start + 1;
            count += len;
        }
    }

    return count;
}

int main()
{

    vi nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
    int total;
    total = numSubarrayProductLessThanK(nums, 19);
    cout << total;
}