//https://www.codechef.com/START62B/problems/SSUBSTR

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
    ll n; cin>>n;
    string s ; cin>>s;
    int count = 0;
    int isOne = 0;
    int isZero =0;
    FOR(i,0,n){
        // cout<<s[i]<<" "<<count;nl;
        if(s[i]=='1' && isOne == 0){
            count++;
            isOne = 1;
        }
        if(s[i]=='0')
        {
            isOne = 0;
        }
    }
    if(s[n-1]=='1' && count >= 1) count--;
    cout<<count;nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}