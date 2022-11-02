// https://leetcode.com/problems/first-missing-positive/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int minMoves2(vector<int> &nums)
{
    sort(nums.begin(), nums.end());
    int start = 0, end = nums.size() - 1;
    int count = 0;
    while (start <= end)
    {
        count += abs(nums[end] - nums[start]);
        start++;
        end--;
    }
    return count;
}
int main()
{
    vi arr = {1, 10, 2, 9};
    cout << minMoves2(arr);
}