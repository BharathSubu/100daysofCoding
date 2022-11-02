// https://leetcode.com/problems/combination-sum/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
#define vs vector<string>

vvi res;
vi arr = {};
int currsum = 0;

void combSum(vi nums, int target, int curri = 0)
{
    if (currsum > target)
    {
        return;
    }
    if (currsum == target)
    {
        res.push_back(arr);
        return;
    }
    if (curri == nums.size())
        return;
    FOR(j, curri, nums.size())
    {
        currsum += nums[j];
        arr.push_back(nums[j]);
        combSum(nums, target, j);
        arr.pop_back();
        currsum -= nums[j];
    }
}

vector<vector<int>> combinationSum(vector<int> &candidates, int target)
{
    combSum(candidates, target, 0);
    return res;
}

int main()
{
    vi nums = {2, 3, 6, 7, 11, 12, 23, 36};
    int target = 40;
    vvi subset = combinationSum(nums, target);
    FOR(i, 0, subset.size())
    {
        FOR(j, 0, subset[i].size())
        {
            cout << subset[i][j] << " ";
        }
        nl;
    }
}