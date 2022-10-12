// https://www.codechef.com/START60B/problems/DISKMOV

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
    ll n, k;
    cin >> n >> k;
    vl arr(n);
    if (k > n)
    {
        cout << "0";
        return;
    }
    int k2 = k;
    unordered_map<ll, ll> map;
    FOR(i, 0, n)
    {
        cin >> arr[i];
        map[arr[i]]++;
    }

    ll newn = 2 * n;
    ll count0 = 0;
    ll count1 = 0;
    ll Max = *max_element(arr.begin(), arr.end());

    FOR(i, 0, newn)
    {
        if (k == 0)
            break;
        if (map.find(i + 1) == map.end())
        {
            ll sub = i + 1;
            Max = max(sub, Max);

            count0 += abs(Max - sub);
            k--;
        }
    }

    arr.push_back(newn);
    Max = newn;
    k2--;
    FOR(i, 0, newn - 1)
    {
        if (k2 == 0)
            break;
        if (map.find(i + 1) == map.end())
        {
            ll sub = i + 1;
            count1 += abs(Max - sub);
            k2--;
        }
    }

    cout << max(count0, count1);
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