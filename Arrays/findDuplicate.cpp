

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORE(a, b, c) for (int(a) = (b); (a) <= (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define all(X) (X).begin(), (X).end()
#define vi vector<int>
#define vvi vector<vector<int>>
#define vl vector<ll>
#define vd vector<double>

int solve()
{
    vi nums = {1, 3, 2, 2, 5};
    set<int> s;
    FOR(i, 0, nums.size())
    {
        if (s.find(nums[i]) == s.end())
            s.insert(nums[i]);
        else
            return nums[i];
    }
}

int main()
{
    int num = solve();
    cout << num;
}