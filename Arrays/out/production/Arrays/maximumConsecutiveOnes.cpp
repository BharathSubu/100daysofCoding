// https://leetcode.com/problems/max-consecutive-ones/

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

int findMaxConsecutiveOnes(vector<int> &nums)
{
    int Max = 0;
    int sum = 0;
    FOR(i, 0, nums.size())
    {
        if (nums[i] == 1)
            sum++;
        else
            sum = 0;
        Max = max(sum, Max);
    }
    return Max;
}

int main()
{

    vi arr = {1, 1, 0, 1, 1, 1, 1, 1, 0, 0};
    cout << findMaxConsecutiveOnes(arr);
}