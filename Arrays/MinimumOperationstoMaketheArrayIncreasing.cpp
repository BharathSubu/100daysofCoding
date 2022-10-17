// https://leetcode.com/problems/the-kth-factor-of-n/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int minOperations(vector<int> &nums)
{
    int count = 0;
    int prev = nums[0];
    FOR(i, 1, nums.size())
    {
        if (prev >= nums[i])
        {
            int sum = prev + 1 - nums[i];
            count += sum;
            prev += 1;
        }
        else
        {
            prev = nums[i];
        }
    }
    return count;
}
int main()
{
    vi arr = {1, 5, 2, 4, 1};
    cout << minOperations(arr);
}