// https://www.codechef.com/START60B/problems/ARRPAL

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

void coutMax()
{
    ll n;
    cin >> n;
    vl arr(n);
    FOR(i, 0, n)
    cin >> arr[i];
    ll i = 0, j = n - 1;
    ll count = arr[j] - arr[i];
    ll mincount = count;
    while (i < n && j > 0)
    {
        if (i >= j)
            break;
        ll sum = arr[j] - arr[i];
        if (sum < 0 || sum > mincount)
        {

            count = -1;
            break;
        }
        mincount = min(sum, mincount);
        i++;
        j--;
    }
    cout << count;
    nl;
}
int main()
{
    ll t;
    cin >> t;
    while (t--)
    {
        coutMax();
    }
}