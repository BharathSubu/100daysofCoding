//https://www.codechef.com/START62B/problems/MAKEMULTIPLE


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
    ll a, b ;
    cin>>a>>b;
    if(b==a)cout<<"YES\n";
    else if(b/a < 2) cout<<"NO\n";
    else cout<<"YES\n"
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}