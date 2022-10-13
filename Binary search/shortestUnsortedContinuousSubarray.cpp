// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int findUnsortedSubarray(vector<int> &nums)
{
    int n = nums.size();
    int Minimum = INT_MAX, Maximum = INT_MIN;
    if (n == 1)
        return 0;
    FOR(i, 0, n - 1)
    {
        if (nums[i] > nums[i + 1])
        {
            Minimum = *min_element(nums.begin() + i + 1, nums.end());
            break;
        }
    }
    FORD(i, n - 1, 1)
    {
        if (nums[i] < nums[i - 1])
        {
            Maximum = *max_element(nums.begin(), nums.begin() + i + 1);
            break;
        }
    }
    if (Minimum == INT_MAX || Maximum == INT_MIN)
        return 0;
    int i = 0, j = 0;
    for (i = 0; i < n && nums[i] <= Minimum; i++)
        ;
    for (j = n - 1; j >= 0 && nums[j] >= Maximum; j--)
        ;
    cout << Minimum << " " << Maximum;
    nl;
    cout << i << " " << j;
    nl;
    return j - i + 1;
}

int main()
{
    vi nums = {1, 2, 3, 4};
    int total;
    total = findUnsortedSubarray(nums);
    cout << total;
}