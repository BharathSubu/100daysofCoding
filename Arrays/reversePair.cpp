// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 5 > 2 * 1

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int merge(vi &nums, int l, int mid, int r)
{
    int count = 0;
    int i = l;
    int j = mid + 1;

    while (i <= mid)
    {
        while (j <= r && nums[i] > 2 * nums[j])
        {
            j++;
        }
        count += (j - (mid + 1));
        i++;
    }

    int lSize = mid - l + 1;
    int rSize = r - mid;
    vi left(lSize);
    vi right(rSize);
    FOR(i, 0, lSize)
    {
        left[i] = nums[l + i];
    }
    FOR(i, 0, rSize)
    {
        right[i] = nums[mid + 1 + i];
    }

    i = 0;
    j = 0;
    int k = l;
    while (i < lSize && j < rSize)
    {
        if (left[i] < right[j])
        {
            nums[k] = left[i];
            k++;
            i++;
        }
        else
        {
            nums[k] = right[j];
            k++;
            j++;
        }
    }
    while (i < lSize)
    {
        nums[k] = left[i];
        k++;
        i++;
    }
    while (j < rSize)
    {
        nums[k] = right[j];
        k++;
        j++;
    }
    return count;
}

int mergesort(vi &nums, int l, int r)
{
    if (l < r)
    {
        int mid = (l + r) / 2;
        int pairs = mergesort(nums, l, mid);
        pairs += mergesort(nums, mid + 1, r);
        pairs += merge(nums, l, mid, r);
        return pairs;
    }
    return 0;
}

int reversePairs(vector<int> &nums)
{
    return mergesort(nums, 0, nums.size() - 1);
}
int main()
{
    vi nums = {40, 25, 19, 12, 9, 6, 2};
    int pairs = reversePairs(nums);
    cout << pairs;
    nl;
    FOR(i, 0, nums.size()) { cout << nums[i] << " "; }
}