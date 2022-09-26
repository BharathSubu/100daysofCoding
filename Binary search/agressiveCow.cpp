// https://youtu.be/wSOfYesTBRk?list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma

#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>

int allocation(vi nums, int mid)
{
    int start = nums[0];
    int cows = 1;
    FOR(i, 1, nums.size())
    {

        if ((nums[i] - start) >= mid)
        {
            cows++;
            start = nums[i];
        }
    }
    return cows;
}

int aggresiveCow(vector<int> &nums, int m)
{
    int n = nums.size();
    int start = nums[0], end = nums[n - 1] - nums[0];
    int minmax = 0;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;

        if (allocation(nums, mid) >= m)
        {
            minmax = mid;
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return minmax;
}

int main()
{

    vi arr = {1, 2, 4, 8, 9};
    ll maxmin = aggresiveCow(arr, 3);
    cout << maxmin;
};
