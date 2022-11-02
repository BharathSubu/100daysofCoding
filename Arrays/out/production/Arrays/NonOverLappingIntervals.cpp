// https://leetcode.com/problems/non-overlapping-intervals/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int eraseOverlapIntervals(vector<vector<int>> &intervals)
{
    int removal = 0;
    sort(intervals.begin(), intervals.end());
    int curr = 0;
    FOR(i, 1, intervals.size())
    {
        if (intervals[curr][1] > intervals[i][0])
        {
            removal++;
            if (intervals[curr][1] >= intervals[i][1])
            {
                curr = i;
            }
        }
        else
        {
            curr = i;
        }
    }
    return removal;
}

int main()
{
    vvi intervals = {{1, 6}, {2, 3}, {3, 6}, {5, 7}};
    cout << eraseOverlapIntervals(intervals);
}