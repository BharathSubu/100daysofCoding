// https://www.codechef.com/START60B/problems/FLIPPAL

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void isPossible()
{
    int n;
    cin >> n;
    string bi;
    cin >> bi;
    int count0 = 0, count1 = 0;
    FOR(i, 0, bi.size())
    {
        if (bi[i] == '1')
            count1++;
        else
            count0++;
    }
    if (count0 % 2 != 0 && count1 % 2 != 0)
    {
        cout << "NO";
    }
    else
        cout << "YES";
    nl;
}
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        isPossible();
    }
}