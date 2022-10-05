// https://www.codechef.com/START59C/problems/CONFCAT
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
    ll n;
    cin >> n;
    vi arr(n);
    FOR(i, 0, n)
    cin >> arr[i];
    ll max = *max_element(arr.begin(), arr.end());
    vi arr1, arr2;
    ll maxfound = 0;
    if (arr[0] == max)
    {
        cout << "-1";
        nl;
        return;
    }
    FOR(i, 0, n)
    {
        if (arr[i] != max && !maxfound)
        {
            arr1.push_back(arr[i]);
        }
        if (arr[i] == max || maxfound)
        {
            arr2.push_back(arr[i]);
            maxfound = 1;
        }
    }
    ll arr1size = arr1.size();
    ll arr2size = arr2.size();
    cout << arr1size;
    nl;
    FOR(i, 0, arr1size)
    cout << arr1[i] << " ";
    nl;
    cout << arr2size;
    nl;
    FOR(i, 0, arr2size)
    cout << arr2[i] << " ";
    nl;
}

int main()
{
    ll t;
    cin >> t;
    while (t--)
        solve();
};
