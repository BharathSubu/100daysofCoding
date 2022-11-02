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
void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
{

    int lSize = m;
    int rSize = n;
    vi left(lSize);
    vi right(rSize);
    FOR(i, 0, lSize)
    {
        left[i] = nums1[i];
    }
    FOR(i, 0, rSize)
    {
        right[i] = nums2[i];
    }

    int i = 0;
    int j = 0;
    int k = 0;
    while (i < lSize && j < rSize)
    {
        if (left[i] < right[j])
        {
            nums1[k] = left[i];
            k++;
            i++;
        }
        else
        {
            nums1[k] = right[j];
            k++;
            j++;
        }
    }
    while (i < lSize)
    {
        nums1[k] = left[i];
        k++;
        i++;
    }
    while (j < rSize)
    {
        nums1[k] = right[j];
        k++;
        j++;
    }
}
int main()
{
    vi nums1 = {1, 2, 3, 0, 0, 0};
    vi nums2 = {2, 5, 6};
    merge(nums1, 3, nums2, 3);
    FOR(i, 0, nums1.size())
    cout << nums1[i] << " ";
}