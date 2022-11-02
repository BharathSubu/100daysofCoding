// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int divsum(vi nums, int div)
{
    int sum = 0;
    FOR(i, 0, nums.size())
    {

        float quo = ceil((float)nums[i] / (float)div);

        sum += quo;
    }

    return sum;
}

int smallestDivisor(vector<int> &nums, int threshold)
{
    int end = INT_MIN;
    FOR(i, 0, nums.size())
    {
        if (end < nums[i])
        {
            end = nums[i];
        }
    }

    int start = 1;
    while (start <= end)
    {

        int mid = start + (end - start) / 2;

        if (divsum(nums, mid) <= threshold)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return start;
};
int main()
{
    vi arr = {44, 22, 33, 11, 1};
    int div = smallestDivisor(arr, 5);
    cout << div;
}