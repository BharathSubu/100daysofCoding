// 229. Majority Element II

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

vector<int> majorityElement(vector<int> &nums)
{
    vi arr;

    int num1 = -1;
    int num2 = -1;

    int c1 = 0;
    int c2 = 0;

    FOR(i, 0, nums.size())
    {
        if (num1 == nums[i])
        {
            c1++;
        }
        else if (num2 == nums[i])
        {
            c2++;
        }
        else if (c1 == 0)
        {
            num1 = nums[i];
            c1++;
        }
        else if (c2 == 0)
        {
            num2 = nums[i];
            c2++;
        }
        else
        {
            c1--;
            c2--;
        }
    }

    int check1 = 0, check2 = 0;
    FOR(i, 0, nums.size())
    {
        if (nums[i] == num1)
            check1++;
        if (nums[i] == num2)
            check2++;
    }

    if (check1 > nums.size() / 3 && num1 != num2)
        arr.push_back(num1);
    if (check2 > nums.size() / 3)
        arr.push_back(num2);

    return arr;
}
int main()
{
    vi nums = {2, 1, 1, 3, 1, 4, 5, 6};
    vi arr;
    arr = majorityElement(nums);
    FOR(i, 0, arr.size())
    cout << arr[i] << " ";
}