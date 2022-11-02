// https://leetcode.com/problems/guess-number-higher-or-lower/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int guessNumber(int n)
{
    int start = 1;
    int end = n;
    while (start < end)
    {
        int mid = (start + end) / 2;
        if (guess(mid) == 0)
        {
            return mid;
        }
        if (guess(mid) == 1)
        {
            start = mid;
        }
        else
        {
            end = mid;
        }
    }
    return -1;
}

int main()
{
    int num = guessNumber(9);
    cout << num;
}