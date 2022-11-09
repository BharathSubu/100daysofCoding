// https://www.codechef.com/START64B/problems/RANGEASSIGN

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vector<vector<int>> merge(vector<vector<int>> intervals)
{
    sort(intervals.begin(), intervals.end());
    vector<vector<int>> combined(intervals.size());
    int k = 0;
    combined[0] = intervals[0];
    int prevstart = intervals[0][1];
    int prevend = intervals[0][1];
    FOR(i, 1, intervals.size())
    {
        if (combined[k][0] <= intervals[i][0] && combined[k][1] >= intervals[i][1])
        {
            continue;
        }
        else if (combined[k][0] <= intervals[i][0] && combined[k][1] <= intervals[i][1])
        {
        }
        else
        {
            k++;
            combined[k] = intervals[i];
        }
    }
    combined.resize(k + 1);

    return combined;
}

void solve()
{
    ll n;
    cin >> n;
    vi nums(n);
    FOR(i, 0, n)
    cin >> nums[i];
    if (n <= 2 || nums[0] == nums[n - 1] || nums[0] == nums[n - 2] || nums[1] == nums[n - 1])
    {
        cout << "YES";
        nl;
        return;
    }

    ll a = nums[0];
    for (ll i = 1; i < n - 1; i++)
    {
        if (nums[i] == nums[0])
        {
            if (nums[i + 1] == nums[n - 1])
            {
                cout << "YES";
                nl;
                return;
            }
        }
    }
    cout << "NO";
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}