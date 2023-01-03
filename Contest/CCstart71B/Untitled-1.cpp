// https : // www.codechef.com/START69B/problems/ADJPAIRSWAP

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

void solve()
{
    int n;
    cin >> n;
    int arr[n];
    FOR(i, 0, n)
    
    cin >> arr[i];
    int i = n - 1, j = n - 1;
    vvi ans;
    while (i != -1 && j != -1)
    {

        if (arr[i] == 0)
        {
            if (j == n - 1)
                j = i - 2;
            while (j != -1 && arr[j] != 1)
            {
                j--;
            }
            if (j == -1)
                break;

            arr[i] = 1;
            arr[j] = 0;
            vi an;
            an.push_back(j);
            an.push_back(i);
            ans.push_back(an);
        }
        i--;
    }
    FOR(i, 0, ans.size())
    {
        cout << ans[i][0] << " " << ans[i][1];
        nl;
    }
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}