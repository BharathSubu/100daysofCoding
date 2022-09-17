// <!-- There are 100 houses located on a straight line. The first house is numbered 1 and the last one is numbered 100. Some M houses out of these 100 are occupied by cops.

// Thief Devu has just stolen PeePee's bag and is looking for a house to hide in.

// PeePee uses fast 4G Internet and sends the message to all the cops that a thief named Devu has just stolen her bag and ran into some house.

// Devu knows that the cops run at a maximum speed of x houses per minute in a straight line and they will search for a maximum of y minutes. Devu wants to know how many houses are safe for him to escape from the cops. Help him in getting this information.

// Input
// First line contains T, the number of test cases to follow.

// First line of each test case contains 3 space separated integers: M, x and y.

// For each test case, the second line contains M space separated integers which represent the house numbers where the cops are residing.

// Output
// For each test case, output a single line containing the number of houses which are safe to hide from cops. -->

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

void solve()
{
    int m, x, y;
    cin >> m >> x >> y;
    vi arr(m);
    FOR(i, 0, m)
    cin >> arr[i];
    sort(arr.begin(), arr.end());
    vvi intervals;
    int housecover = x * y;
    FOR(i, 0, m)
    {
        int Lstart = arr[i] - housecover;
        int Rend = arr[i] + housecover;
        vi interval;
        if (Lstart < 1)
        {
            interval.pb(1);
        }
        else
            interval.pb(Lstart);
        if (Rend > 100)
        {
            interval.pb(100);
        }
        else
            interval.pb(Rend);
        intervals.pb(interval);
    }

    vvi refinedintervals;
    vi frstarr = {-1, -1};
    frstarr[0] = intervals[0][0], frstarr[1] = intervals[0][1];
    refinedintervals.pb(frstarr);
    int start = 0;
    FOR(i, 1, intervals.size())
    {
        if (intervals[i][0] >= refinedintervals[start][0] && intervals[i][0] <= refinedintervals[start][1])
        {
            if (intervals[i][1] > refinedintervals[start][1])
            {
                refinedintervals[start][1] = intervals[i][1];
            }
            // cout << refinedintervals[start][0] << " " << refinedintervals[start][1];
            // nl
        }
        else
        {
            vi arr;
            arr.pb(intervals[i][0]);
            arr.pb(intervals[i][1]);
            refinedintervals.pb(arr);
            start++;
        }
    }
    int count = refinedintervals[0][0] - 1;
    FOR(i, 1, refinedintervals.size())
    {

        count += refinedintervals[i][0] - refinedintervals[i - 1][1] - 1;
    }
    count += 100 - refinedintervals[refinedintervals.size() - 1][1];

    cout << count;
    nl;
}
int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}
