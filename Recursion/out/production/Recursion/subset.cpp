// https://leetcode.com/problems/subsets/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vvi res;
vi arr;
vector<vector<int>> subsets(vector<int> &nums, vi arr = {}, int j = 0)
{

    if (j == nums.size())
    {
        // FOR(i,0,arr.size()) cout<<arr[i]<<" "; nl;
        return res;
    }

    FOR(i, j, nums.size())
    {

        arr.push_back(nums[i]);
        res.push_back(arr);
        subsets(nums, arr, i+1 );
        arr.pop_back();
    }
    return res;
}

int main()
{
    vi nums = {1, 2, 3,4};
    vvi subset = subsets(nums);
    FOR(i, 0, subset.size())
    {
        FOR(j, 0, subset[i].size())
        {
            cout << subset[i][j] << " ";
        }
        nl;
    }
}