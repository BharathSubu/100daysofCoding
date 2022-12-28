// https://codechef.com/START71B/problems/PREFIXFLIP

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vector<pair<char, int>> compress(string s, int k)
{

    int isZero = 0;
    int isOne = 1;
    vector<pair<char, int>> res;
    for (int i = 0; s[i] != '\0'; i++)
    {
        int count = 1;
        while (s[i] == s[i + 1])
        {
            i++;
            count++;
        }
        if (s[i] == '0')
            isZero = max(isZero, count);
        if (s[i] == '1')
            isOne = max(isOne, count);
        pair<char, int> r;
        r.first = s[i];
        r.second = count;
        res.push_back(r);
    }
    vector<pair<char, int>> ans;
    pair<char, int> p;

    if (isOne >= k)
    {
        p.first = '0';
        p.second = 0;
        ans.push_back(p);
        return ans;
    }
    if (isZero >= k)
    {
        p.first = '1';
        p.second = 1;
        ans.push_back(p);
        return ans;
    }
    return res;
}
bool lessThanByLen(pair<char, int> _a, pair<char, int> _b)
{
    return _a.second < _b.second;
}
void solve()
{
    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;
    int t;
    cin >> t;
    while (t--)
    {
        int a, b, ans = INT_MAX;
        cin >> a >> b;
        string s;
        cin >> s;
        int arr[a];
        int count = 0;
        for (int i = 1; i < a; i++)
        {
            if (s[i - 1] != s[i])
            {
                count++;
                arr[i] = count;
            }
            else
                arr[i] = count;
        }
        arr[0] = 0;
        for (int i = a - 1; i >= 0; i--)
        {
            if ((i - (b - 1)) < 0)
                break;
            int check = arr[i] - arr[i - b + 1];
            if (s[i] == '0')
                check++;
            ans = min(ans, check);
        }
        cout << ans << endl;
    }
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}