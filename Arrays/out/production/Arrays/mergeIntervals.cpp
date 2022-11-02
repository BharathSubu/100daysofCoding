// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void solve()
{
    vector<vector<int>> intervals = {{1, 4}, {2, 3}};
    sort(intervals.begin(), intervals.end());
    vector<vector<int>> combined(intervals.size());
    int k = 0;
    combined[0] = intervals[0];
    FOR(i, 1, intervals.size())
    {
        if (combined[k][1] >= intervals[i][0])
        {
            if (combined[k][1] < intervals[i][1])
                combined[k][1] = intervals[i][1];
        }
        else
        {
            k++;
            combined[k] = intervals[i];
        }
    }
    combined.resize(k);
    FOR(i, 0, k + 1)
    {
        cout << combined[i][0] << " " << combined[i][1];
        nl;
    }
}

int main()
{
    solve();
}