// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

// time limit exceeded
// int longestConsecutive(vector<int> &nums)
// {
//     int maxlen = 1;
//     int count = 0;
//     set<int> s;
//     FOR(i, 0, nums.size())
//     {
//         s.insert(nums[i]);
//     }
//     int start = -1, end = -1;
//     int step = 0;
//     FOR(i, 0, nums.size())
//     {
//         int k = 1;
//         count = 1;
//         while (s.find(nums[i] - k) != s.end())
//         {
//             count++;
//             step++;
//             k++;
//         }
//         start = nums[i];
//         end = nums[i] + k;
//         maxlen = max(count, maxlen);
//     }
//     cout << step;
//     nl;
//     return maxlen;
// }

int longestConsecutive(vector<int> &nums)
{
    if (nums.size() == 0)
        return 0;
    int maxlen = 1;
    int count = 1;
    set<int> s;
    FOR(i, 0, nums.size())
    {
        s.insert(nums[i]);
    }
    int step = 0;
    FOR(i, 0, nums.size())
    {
        if (s.find(nums[i] - 1) == s.end())
        {
            int k = 1;
            while (s.find(nums[i] + k) != s.end())
            {
                count++;
                k++;
            }
            maxlen = max(count, maxlen);
        }
    }

    return maxlen;
}

int main()
{
    vi nums = {-1, 1, 0};
    int len;
    len = longestConsecutive(nums);
    cout << len;
}