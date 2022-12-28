// https://www.codechef.com/START69B/problems/DISTINCTSEQ

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
    string s;
    cin >> s;
    int c1 = 0, c0 = 0;
    vi c1Arr, c0Arr;
    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == '1')
        {
            c1++;
            c1Arr.push_back(i);
        }
        else
        {
            c0++;
            c0Arr.push_back(i);
        }
    }
    if (c1 == s.size() || c0 == s.size())
    {
        cout << "-1";
        nl;
        return;
    }
    vi A;
    for (int i = 0; i < c1Arr.size() && i < n; i++)
    {
        A.push_back(c1Arr[i]);
    }
    if (A.size() != n)
    {
        int len = 0;
        for (int i = A.size(); i < n; i++)
        {
            A.push_back(c0Arr[len]);
            len++;
        }
    }
    sort( A.begin(), A.end() );
    for (int i = 0; i < A.size(); i++)
    {
        cout << A[i]+1 << " ";
    }
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}