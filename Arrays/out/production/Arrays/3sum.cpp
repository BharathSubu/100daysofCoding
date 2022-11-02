// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.
// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation:
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

vector<vector<int>> fourSum(vector<int> &nums, int target)
{
    vvi arr;
    if (nums.size() < 3)
        return arr;
    ll n = nums.size();
    sort(nums.begin(), nums.end());

    FOR(j, 0, n - 2)
    {
        ll sumtofind = 0 - nums[j];
        ll k = j + 1, l = n - 1;
        while (k < l)
        {
            if (nums[k] + nums[l] == sumtofind)
            {
                vi res;
                res.pb(nums[j]);
                res.pb(nums[k]);
                res.pb(nums[l]);
                arr.pb(res);
                l--;
            }
            else if (nums[k] == nums[l])
            {
                break;
            }
            else if (nums[k] + nums[l] < sumtofind)
                k++;

            else
            {
                l--;
            }
        }
        if (nums[0] == nums[nums.size() - 1])
            break;
        while (j + 1 < n && nums[j + 1] == nums[j])
            ++j;
    }

    sort(arr.begin(), arr.end());
    arr.erase(std::unique(arr.begin(), arr.end()), arr.end());
    return arr;
}

int main()
{
    vi nums = {-3, -2, -1, 0, 0, 1, 2, 3};
    vvi arr;
    arr = fourSum(nums, 0);
    FOR(i, 0, arr.size())
    {
        cout << arr[i][0] << " " << arr[i][1] << " " << arr[i][2];
        nl;
    }
}