// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

vector<int> twoSum(vector<int> &nums, int target)
{
    vi arr = {-1, -1};
    set<int> check;
    FOR(i, 0, nums.size())
    {
        check.insert(nums[i]);
    }
    if (target % 2 == 0)
    {
        int count = 0;
        FOR(i, 0, nums.size())
        {
            if (nums[i] == target / 2)
            {
                arr[count] = i;
                count++;
            }
            if (count == 2)
                return arr;
        }
    }
    int k = 0;
    FOR(i, 0, nums.size())
    {
        int num = target - nums[i];
        if (check.find(num) != check.end() && nums[i] != num)
        {
            arr[k] = i;
            k++;
        }

        if (k == 2)
            return arr;
    }
    return arr;
}
int main()
{
    vi nums = {3, 2, 4, 3, 4};
    vi arr = {-1, -1};
    arr = twoSum(nums, 6);
    cout << arr[0] << " " << arr[1];
}