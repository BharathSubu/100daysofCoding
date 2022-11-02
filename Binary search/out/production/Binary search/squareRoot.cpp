
// https://practice.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
long long int floorSqrt(long long int x)
{
    long long int start = 1, end = x;
    long long int res = -1;
    while (start <= end)
    {
        long long int mid = start + (end - start) / 2;
        long long int sq = mid * mid;
        if (sq == x)
        {
            return mid;
        }
        else if (sq > x)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
            res = mid;
        }
    }
    return res;
}
int main()
{

    cout << floorSqrt(99);
}