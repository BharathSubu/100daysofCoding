// https://leetcode.com/problems/koko-eating-bananas/

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

bool iseaten(vi &piles, ll k, ll maxh)
{
    ll hours = 0;

    FOR(i, 0, piles.size())
    {
        if (piles[i] % k == 0)
            hours += piles[i] / k;
        else
            hours += piles[i] / k + 1;
    }
    if (hours <= maxh)
        return true;
    else
        return false;
}

int minEatingSpeed(vector<int> &piles, ll h)
{

    ll start = 1, end = INT_MIN;
    FOR(i, 0, piles.size())
    {
        if (end < piles[i])
        {
            end = piles[i];
        }
    }
    ll k = end;
    while (start <= end)
    {
        ll mid = start + (end - start) / 2;
        if (iseaten(piles, mid, h))
        {
            k = mid;
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return k;
}

int main()
{

    vi arr = {805306368, 805306368, 805306368};
    ll k = minEatingSpeed(arr, 1000000000);
    cout << k;
};
