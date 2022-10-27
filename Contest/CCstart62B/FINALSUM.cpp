
//https://www.codechef.com/START62B/problems/FINALSUM

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
    ll n , q;
    cin >>n>>q;
    vi arr(n);
    ll count = 0;
    FOR(i,0,n) {
        ll num ;
        cin>>num;
        count+=num;
    }
    FOR(i,0,q){
        ll l , r;
        cin>>l>>r;
        
        if((r-l+1)%2 != 0){
            count++;
        }
    }
    cout<<count;
    nl;
    
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}