// https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

bool canBeIncreasing(vector<int> &nums)
{
    int n = nums.size();
    if (n == 1)
        return true;
    int last = nums[n - 1];
    int count = 0;
    for (int i = n - 2; i >= 0; i--)
    {
        if (last <= nums[i])
        {
            count++;
        }
        else
        {
            last = nums[i];
        }
    }
    int count1 = 0;
    int first = nums[0];
    for (int i = 1; i < n; i++)
    {
        if (first >= nums[i])
        {
            count1++;
        }
        else
        {
            first = nums[i];
        }
    }

    int mincount = min(count1, count);
    if (mincount > 1)
        return false;
    return true;
}
int main()
{
    vi arr = {1, 2, 10, 5, 7};
    cout << canBeIncreasing(arr);
}