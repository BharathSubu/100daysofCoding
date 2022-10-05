// https://www.codechef.com/START59C/problems/ALTSUFF

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
    int k;
    string s;
    cin >> n >> k >> s;
    string res = s;
    while (k--)
    {
        string newres = res;
        FOR(i, 0, n)
        {
            if (res[i] == '1')
                newres[i] = '0';
        }
        FOR(i, 0, n)
        {
            if (res[i] == '1')
            {

                if (i - 1 > -1 && res[i - 1] == '0')
                {
                    newres[i - 1] = '1';
                }
                if (i + 1 < n && res[i + 1] == '0')
                {
                    newres[i + 1] = '1';
                }
            }
        }
        res = newres;
    }
    cout << res << " ";
    nl;
}

int main()
{
    ll t;
    cin >> t;
    while (t--)
        solve();
};
