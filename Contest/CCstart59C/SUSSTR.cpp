// https://www.codechef.com/START59C/problems/SUSSTR
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
#define pb push_back

void solve()
{
    int n;
    string s;
    cin >> n >> s;
    int i = 0, j = n - 1;
    string res = "";
    while (i <= j)
    {
        if (s[i] == '0')
            res = '0' + res;
        else
            res += '1';
        if (i >= j)
            break;
        i++;
        if (s[j] == '1')
            res = '1' + res;
        else
            res += '0';
        j--;
    }
    cout << res;
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
};
