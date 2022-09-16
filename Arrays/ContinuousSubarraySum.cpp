// Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
// Example 1:

// Input: nums = [23,2,4,6,7], k = 6
// Output: true
// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
// Example 2:

// Input: nums = [23,2,6,4,7], k = 6
// Output: true
// Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
// 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// Example 3:

// Input: nums = [23,2,6,4,7], k = 13
// Output: false

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

bool checkSubarraySum(vector<int> &nums, int k)
{
    map<int, int> m;
    int sum = 0;
    m.insert({0, -1});

    for (int i = 0; i < nums.size(); i++)
    {
        sum = sum + nums[i];
        if (m.count(sum % k) && i - m[sum % k] > 1)
            return 1;
        else if (!m.count(sum % k))
            m[sum % k] = i;
    }

    return 0;
}
int main()
{

    vi nums = {23, 2, 4, 13, 6};
    bool isthere;
    isthere = checkSubarraySum(nums, 7);
    cout << isthere;
}