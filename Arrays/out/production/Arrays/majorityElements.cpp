// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
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

int majorityElement(vector<int> &nums)
{
    int num = -1;
    int count = 0;
    FOR(i, 0, nums.size())
    {
        if (count == 0)
        {
            num = nums[i];
            count++;
        }
        else if (num == nums[i])
        {
            count++;
        }
        else
        {
            count--;
        }
        cout << count;
        nl;
    }

    int checkcount = 0;
    FOR(i, 0, nums.size())
    {
        if (nums[i] == num)
            checkcount++;
    }
    cout << checkcount << " " << num;
    nl;
    if (checkcount > nums.size() / 2)
        return num;
    else
        return -1;
}
int main()
{
    vi nums = {3, 3, 4};
    int arr = majorityElement(nums);
    cout << num;
}