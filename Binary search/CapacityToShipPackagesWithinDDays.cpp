// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

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

bool isShipped(vi weights, int mid, int days)
{
    int shipped = 0;
    int d = 1;
    FOR(i, 0, weights.size())
    {
        shipped += weights[i];
        if (shipped > mid)
        {
            d++;
            shipped = weights[i];
        }
        if (weights[i] > mid)
            return false;
    }
    if (d <= days)
        return true;
    return false;
}

int shipWithinDays(vector<int> &weights, int days)
{
    int start = 1, end = 0;
    FOR(i, 0, weights.size())
    {
        end += weights[i];
    }
    int w = end;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (isShipped(weights, mid, days))
        {
            w = mid;
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return w;
}

int main()
{

    vi arr = {1, 2, 3, 1, 1};
    ll w = shipWithinDays(arr, 4);
    cout << w;
};
