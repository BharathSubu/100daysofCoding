// https://leetcode.com/problems/subarray-sums-divisible-by-k/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int longestMountain(vector<int> &arr)
{
    int n = arr.size();
    int len = 0;
    int left = 0, right = 0;
    FOR(i, 0, n - 1)
    {
        if (i != 0 && arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
        {
            if (left != 0 && right != 0)
                len = max(len, left + right + 1);
            left = 0;
            right = 0;
        }
        if (arr[i] < arr[i + 1])
            left++;
        if (arr[i] > arr[i + 1])
            right++;
        if (arr[i] == arr[i + 1])
        {
            if (left != 0 && right != 0)
                len = max(len, left + right + 1);
            left = 0;
            right = 0;
        }
    }
    if (left != 0 && right != 0)
        len = max(len, left + right + 1);
    return len;
}
int main()
{
    vi arr = {0, 2, 0, 2, 1, 2, 3, 4, 4, 1};
    cout << longestMountain(arr);
}