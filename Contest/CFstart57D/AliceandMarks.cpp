// https://www.codechef.com/START57D/problems/MARKSTW

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
    int a, b;
    cin >> a >> b;
    if (a >= b * 2)
        cout << "YES";
    else
        cout << "NO";
}

int main()
{
    solve();
}