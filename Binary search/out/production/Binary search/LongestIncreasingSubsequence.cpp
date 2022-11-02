// https://leetcode.com/problems/longest-increasing-subsequence
#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>
#define pb push_back

int lengthOfLIS(vector<int> &nums)
{
    int n = nums.size();
    vi res;
    res.pb(nums[0]);
    FOR(i, 1, n)
    {

        int s = res.size();
        if (nums[i] <= res[0])
        {
            res[0] = nums[i];
        }
        else if (nums[i] == res[s - 1])
        {
            res[s - 1] = nums[i];
        }
        else if (nums[i] > res[s - 1])
        {
            // cout << "hh";
            res.push_back(nums[i]);
        }
        else
        {
            int start = 0, end = s - 1;
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                if (res[mid] == nums[i])
                    break;
                if (res[mid] < nums[i] && res[mid + 1] > nums[i])
                {
                    res[mid + 1] = nums[i];
                    break;
                }
                if (res[mid] > nums[i])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
    }

    return res.size();
}
int main()
{

    vi nums = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
    cout << lengthOfLIS(nums);
    nl;
};
