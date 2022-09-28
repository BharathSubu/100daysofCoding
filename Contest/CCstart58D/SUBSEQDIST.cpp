// https://www.codechef.com/START58D/problems/SUBSEQDIST

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

void solve()
{
    int n;
    cin >> n;
    vi nums(n);
    FOR(i, 0, n)
    cin >> nums[i];
    int max = INT_MIN;
    unordered_map<int, int> map;

    FOR(i, 0, n)
    {
        if (map.find(nums[i]) == map.end())
        {
            map[nums[i]] = 1;
        }
        else
            map[nums[i]]++;
        if (map[nums[i]] > max)
        {
            max = map[nums[i]];
        }
    }
    cout << ceil(log2(max));
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
