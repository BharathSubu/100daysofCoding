// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.
// A subarray is a contiguous subsequence of the array.
// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int maxProduct(vector<int> &nums)
{
    int maxLeft = nums[0];
    int maxRight = nums[0];
    int product = 1;
    bool isZero = false;
    int n = nums.size();
    FOR(i, 0, n)
    {
        product *= nums[i];

        if (nums[i] == 0)
        {
            isZero = true;
            product = 1;
            continue;
        }
        maxLeft = max(maxLeft, product);
    }
    product = 1;

    FORD(i, n - 1, 0)
    {
        product *= nums[i];

        if (nums[i] == 0)
        {
            isZero = true;
            product = 1;
            continue;
        }
        maxRight = max(maxRight, product);
    }
    if (isZero)
        return max(max(maxLeft, maxRight), 0);
    else
        return max(maxLeft, maxRight);
}
int main()
{
    vi nums = {2, 3, -2, 4};
    int maxP;
    maxP = maxProduct(nums);
    cout << maxP;
}