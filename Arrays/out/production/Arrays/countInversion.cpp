// Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

// What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

// Example 1:

// Input Format: N = 5, array[] = {1,2,3,4,5}

// Result: 0

// Explanation: we have a sorted array and the sorted array
// has 0 inversions as for i < j you will never find a pair
// such that A[j] < A[i]. More clear example: 2 has index 1
// and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an
// inversion.
// Example 2:

// Input Format: N = 5, array[] = {5,4,3,2,1}

// Result: 10

// Explanation: we have a reverse sorted array and we will
// get the maximum inversions as for i < j we will always
// find a pair such that A[j] < A[i].
// Example: 5 has index 0 and 3 has index 2 now (5,3) pair
// is inversion as 0 < 2 and 5 > 3 which will satisfy out
// conditions and for reverse sorted array we will get
// maximum inversions and that is (n)*(n-1) / 2.

// For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

long long merge(vi &nums, long long l, long long mid, long long r)
{
    long long count = 0;
    long long lSize = mid - l + 1;
    long long rSize = r - mid;
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

    long long i = 0;
    long long j = 0;
    long long k = l;
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
            count += lSize - i;
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

long long mergesort(vi &nums, long long l, long long r)
{
    if (l < r)
    {
        long long mid = (l + r) / 2;
        long long pairs = mergesort(nums, l, mid);
        pairs += mergesort(nums, mid + 1, r);
        pairs += merge(nums, l, mid, r);
        return pairs;
    }
    return 0;
}

long long getInversions(vector<int> &nums, int n)
{
    return mergesort(nums, 0, n - 1);
}
int main()
{
    vi nums = {2, 5, 1, 3, 4};
    long long pairs = getInversions(nums, nums.size());
    cout << pairs;
}