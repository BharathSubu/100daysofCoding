// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

bool search(vector<int> &nums, int target)
{

    int start = 0, end = nums.size() - 1;
    int peak = -1;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return true;
        if (nums[start] == nums[mid] && nums[mid] == nums[end])
        {
            start++;
            end--;
            
        }
        else if (nums[start] <= nums[mid])
        {
            if (nums[start] <= target && nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        else
        {
            if (nums[mid] <= target && target <= nums[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
    }
    return false;
}

int main()
{

    vi arr = {2,5,6,0,0,1,2};
    bool isthere = search(arr, 3);
    cout << isthere;
}