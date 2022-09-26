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

bool isAvailable(vector<int> &bloomDay, int m, int k, int mid)
{
    int flowers = 0;
    int boq = 0;
    FOR(i, 0, bloomDay.size())
    {
        if (bloomDay[i] <= mid)
        {
            flowers++;
        }
        else
        {
            boq += flowers / k;
            flowers = 0;
        }
    }
    boq += flowers / k;
    if (boq >= m)
        return true;
    return false;
}

int minDays(vector<int> &bloomDay, int m, int k)
{
    if (m * k > bloomDay.size())
    {
        return -1;
    }
    int start = INT_MAX, end = INT_MIN;
    FOR(i, 0, bloomDay.size())
    {
        if (end < bloomDay[i])
        {
            end = bloomDay[i];
        }
        if (start > bloomDay[i])
        {
            start = bloomDay[i];
        }
    }
    int d = end;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (isAvailable(bloomDay, m, k, mid))
        {
            d = mid;
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    return d;
}

int main()
{
    vi arr = {7, 7, 7, 7, 12, 7, 7};
    ll d = minDays(arr, 2, 3);
    cout << d;
};
