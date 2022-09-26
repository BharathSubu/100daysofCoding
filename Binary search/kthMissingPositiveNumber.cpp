// https://leetcode.com/problems/kth-missing-positive-number/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int compute(int actual, int expected)
{
    return actual - expected;
}

int findKthPositive(vector<int> &arr, int k)
{
    int start = 0, end = arr.size() - 1;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        int missing = compute(arr[mid], mid + 1);
        if (missing >= k)
            end = mid - 1;
        else
        {
            start = mid + 1;
        }
    }
    if (end == -1)
        return k;

    return arr[end] + k - compute(arr[end], (end + 1));
}


int main()
{
    vi arr = {2, 3, 4, 7, 11};
    int k = 1;
    cout << findKthPositive(arr, k);
}