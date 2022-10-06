// https://www.codechef.com/START59C/problems/ALTSUFF

// upsolve

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

// void solve()
// {
//     int n;
//     int k;
//     string s;
//     cin >> n >> k >> s;
//     string res = s;
//     while (k--)
//     {
//         string newres = res;
//         FOR(i, 0, n)
//         {
//             if (res[i] == '1')
//                 newres[i] = '0';
//         }
//         FOR(i, 0, n)
//         {
//             if (res[i] == '1')
//             {
//                 if (i - 1 > -1 && res[i - 1] == '0')
//                 {
//                     newres[i - 1] = '1';
//                 }
//                 if (i + 1 < n && res[i + 1] == '0')
//                 {
//                     newres[i + 1] = '1';
//                 }
//             }
//         }
//         res = newres;
//     }
//     cout << res << " ";
//     nl;
// }

void solve()
{
    ll n, k;
    cin >> n >> k;
    string s;
    cin >> s;
    k--;
    string t = s;
    FOR(i, 0, n)
    {
        if (s[i] == '1')
        {
            t[i] = '0';
        }
        else if (i > 0 && s[i - 1] == '1')
        {
            t[i] = '1';
        }
        else if (i < n - 1 && s[i + 1] == '1')
        {
            t[i] = '1';
        }
        else
        {
            t[i] = '0';
        }
    }
    set<int> st;
    FOR(i, 0, n)
    {
        if (t[i] == '1')
            st.emplace(i);
    }
    string ans;
    FOR(i, 0, n)
    {
        auto iter = st.lower_bound(i);
        int d = k + 1;
        if (iter != st.end())
        {
            d = min(d, *iter - i);
        }
        if (iter != st.begin())
        {
            iter--;
            d = min(d, i - *iter);
        }
        if (d <= k && d % 2 == k % 2)
        {
            ans += '1';
        }
        else
        {
            ans += '0';
        }
    }
    cout << ans;
    nl;
}

int main()
{
    ll t;
    cin >> t;
    while (t--)
        solve();
};
