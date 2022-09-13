// Length of the longest subarray with zero Sum
// Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

// Example 1:

// Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}

// Result: 5

// Explanation: The following subarrays sum to zero:
// {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
// Since we require the length of the longest subarray, our answer is 5!
// Example 2:

// Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}

// Result: 8

// Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
// Length of longest subarray = 8
// Example 3:

// Input Format: N = 3, array[] = {1, 0, -5}

// Result: 1

// Subarray : {0}
// Length of longest subarray = 1
// Example 4:
// Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
// Result: 0
// Subarray: There is no subarray that sums to zero

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int maxLen(vector<int> &A, int n)
{
    unordered_map<int, int> mpp;
    int maxi = 0;
    int sum = 0;
    FOR(i, 0, n)
    {
        sum += A[i];
        if (sum == 0)
        {
            maxi = i + 1;
        }
        else
        {
            if (mpp.find(sum) != mpp.end())
            {
                maxi = max(maxi, i - mpp[sum]);
            }
            else
            {
                mpp[sum] = i;
            }
        }
    }

    return maxi;
}
int main()
{
    vi nums = {-1, 1, -1, 1};
    int len = maxLen(nums, nums.size());
    cout << len;
}