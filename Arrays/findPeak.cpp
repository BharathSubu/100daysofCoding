// https://leetcode.com/problems/find-peak-element/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int findPeakElement(vector<int> &nums)
{

    int start = 0, end = nums.size() - 1;
    int peak = -1;
    while (start < end)
    {

        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[mid + 1])
        {
            end = mid;
        }
        else
        {
            start = mid + 1;
        }
    }
    return start;
}

int main()
{
    vi arr = {2, 1};
    int peak = findPeakElement(arr);
    cout << peak;
}