// https://www.codechef.com/START57D/problems/EVENSPLIT

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

string solve()
{
    int n;
    cin >> n;
    string s;
    cin >> s;
    if (n <= 2)
    {
        return s;
    }
    sort(s.begin(), s.end());

    return s;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string s = solve();
        cout << s;
        nl;
    }

    return 0;
}