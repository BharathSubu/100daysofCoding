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

int subarraysDivByK(vector<int> &nums, int k)
{
    int n = nums.size();
    unordered_map<int, int> map;
    map[0] = 1;
    int sum = 0;
    int count = 0;

    FOR(i, 0, n)
    {
        sum += nums[i];
        int rem = sum % k;
        if (rem < 0)
            rem += k;
        cout << nums[i] << " " << sum << " " << rem << " " << count;
        nl;
        if (map.find(rem) != map.end())
        {

            count += map[rem];
        }
        map[rem]++;
    }
    return count;
}
int main()
{

    vi arr = {2, -2, 2, -4, -10, -2};
    cout << subarraysDivByK(arr, 6);
}