// Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
// Pre-req: Binary Search and 2-sum problem

// Note:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// arr[a] + arr[b] + arr[c] + arr[d] == target
// Example 1:

// Input Format: arr[] = [1,0,-1,0,-2,2], target = 0

// Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Explanation: We have to find unique quadruplets from
// the array such that the sum of those elements is
// equal to the target sum given that is 0.

// The result obtained is such that the sum of the
// quadruplets yields 0.
// Example 2:

// Input Format: arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9

// Result: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]

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
    ll n = nums.size();
    sort(nums.begin(), nums.end());
    FOR(i, 0, nums.size() - 3)
    {

        FOR(j, i + 1, n - 2)
        {
            ll sum = nums[i] + nums[j];
            ll sumtofind = target - sum;
            ll k = j + 1, l = n - 1;
            while (k < l)
            {
                if (nums[k] + nums[l] == sumtofind)
                {
                    vi res;
                    res.pb(nums[i]);
                    res.pb(nums[j]);
                    res.pb(nums[k]);
                    res.pb(nums[l]);
                    arr.pb(res);
                    l--;
                }
                else if (nums[k] + nums[l] < sumtofind)
                    k++;
                else
                {
                    l--;
                }
            }
        }
        if (nums[0] == nums[nums.size() - 1])
            break;
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
        cout << arr[i][0] << " " << arr[i][1] << " " << arr[i][2] << " " << arr[i][3];
        nl;
    }
}