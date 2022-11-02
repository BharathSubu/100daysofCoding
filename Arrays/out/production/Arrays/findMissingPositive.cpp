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

int firstMissingPositive(vector<int> &nums)
{
    int n = nums.size();
    unordered_map<int, int> map;
    FOR(i, 0, n)
    {
        if (nums[i] > 0)
            map[nums[i]]++;
    }
    if (map.find(1) == map.end())
        return 1;
    else
    {
        int num = 1;
        while (map.find(num) != map.end())
        {
            num++;
        }
        return num;
    }
}
int main()
{
    vi arr = {1, 2, 0};
    cout << firstMissingPositive(arr);
}