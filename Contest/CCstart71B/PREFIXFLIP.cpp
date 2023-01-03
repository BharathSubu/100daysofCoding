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
    vector<pair<char, int>> comp = compress(s,k);
    if(comp.size()==1) {
        cout<<comp[0].first;
        nl;
        return;
    }
    int res = s.length();
    
    
    
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}