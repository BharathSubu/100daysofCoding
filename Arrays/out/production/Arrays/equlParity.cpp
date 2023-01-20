// https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/equal-parity-ccc0c1dd/
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

void solve()
{
    ll n;
    cin >> n;
    n = 2 * n;
    ll nums[n];
    for (ll i = 0; i < n; i++)
        cin >> nums[i];
    ll countE = 0;
    ll countO = 0;
    ll power2 = 0;
    ll count2 = 0;
    for (ll i = 0; i < n; i++)
    {
        cout << countO << " " << countE << " " << power2 << "\n";
        if (nums[i] & 1)
            countO++;
        else
            countE++;

        if (nums[i] != 1 && nums[i] != 2 && !(nums[i] & 1))
        {
            while (!(nums[i] & 1) && (nums[i] != 2) && (nums[i] != 1))
            {
                nums[i] = nums[i]/ 2;
                power2++;
            }
        }
    }

    if (countE == countO || (n >> 1 == countE))
    {
        cout << "YES\n";
        return;
    }
    if (countO < countE)
    {
        cout << "YES\n";
        return;
    }
    if (countE < countO)
    {
        if ((power2) > ((n >> 1) - countE))
            cout << "YES\n";
        else
            cout << "NO\n";
        return;
    }

    cout << "YES";
    cout << "\n";
}
int main()
{
    ll num;
    cin >> num; // Reading input from STDIN
    while (num--)
    {
        solve();
    }
}