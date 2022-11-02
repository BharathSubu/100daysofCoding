// https://leetcode.com/problems/search-insert-position/submissions/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int search(vector<int> &nums, int target)
{
    int start = 0, end = nums.size() - 1;
    if (nums[end] < target)
    {
        return nums.size();
    }
    if (nums[start] > target)
    {
        return 0;
    }
    while (start <= end)
    {
        long int mid = start + (end - start) / 2;
        if (nums[mid] == target || (nums[mid] > target && nums[mid - 1] < target))
        {
            return mid;
        }
        if (nums[mid] > target)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return -1;
}

int main()
{
    vi arr = {1, 5, 6 7, 8, 9, 10, 19, 20};
    int index = search(arr, 9);
    cout << num;
}