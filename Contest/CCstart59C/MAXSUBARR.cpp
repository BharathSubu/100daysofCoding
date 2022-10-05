// https://www.codechef.com/START59C/problems/MAXSUBARR

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

ll maxSubArraySum(vl a, ll size)
{
    ll max_so_far = INT_MIN, max_ending_here = 0;

    for (ll i = 0; i < size; i++)
    {
        max_ending_here = max_ending_here + a[i];
        if (max_so_far < max_ending_here)
            max_so_far = max_ending_here;

        if (max_ending_here < 0)
            max_ending_here = 0;
    }
    return max_so_far;
}

void solve()
{
    ll n;
    cin >> n;
    vl arrA(n);
    FOR(i, 0, n)
    cin >> arrA[i];
    ll m;
    cin >> m;
    vl arrB(n);
    FOR(i, 0, m)
    cin >> arrB[i];

    vl arrFirst;
    vl arrSecond;
    FOR(i, 0, n)
    {
        arrFirst.push_back(arrA[i]);
        arrSecond.push_back(arrA[i]);
    }
    FOR(i, 0, m)
    {
        if (arrB[i] < 0)
        {
            arrFirst.push_back(arrB[i]);
            arrSecond.insert(arrSecond.begin(), arrB[i]);
        }
        else
        {
            arrSecond.push_back(arrB[i]);
            arrFirst.insert(arrFirst.begin(), arrB[i]);
        }
    }
    ll maxFirst = maxSubArraySum(arrFirst, arrFirst.size());
    ll maxSecond = maxSubArraySum(arrSecond, arrSecond.size());

    ll maximum = max(maxFirst, maxSecond);
    cout << maximum;
    nl;
}

int main()
{
    ll t;
    cin >> t;
    while (t--)
        solve();
};
