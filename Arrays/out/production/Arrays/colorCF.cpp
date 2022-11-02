// https://www.codechef.com/submit/COLOUR

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void solve()
{
    int n = 3;
    vi arr(3);
    int count = 0;
    FOR(i, 0, n)
    {
        cin >> arr[i];
        arr[i]--;
        if (arr[i] >= 0)
            count++;
        else
            arr[i] = 0;
    }
    sort(arr.begin(), arr.end(), greater<int>());
    FOR(i, 0, n - 1)
    {
        FOR(j, i + 1, n)
        {
            if (arr[i] > 0 && arr[j] > 0)
            {
                count++;
                arr[i]--;
                arr[j]--;
            }
        }
    }
    cout << count;
    nl;
}

int main()
{
    ll t;
    cin >> t;
    while (t--)
        solve();
}