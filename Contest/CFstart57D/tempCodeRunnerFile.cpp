// https://www.codechef.com/START57D/problems/EVENSPLIT

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

string rec(int n, string s, string prev)
{

    string org = s;
    if (prev == s)
        return s;
    prev = s;
    vi countE0, countO0, countE1, countO1;
    FOR(i, 0, s.length())
    {
        if (s[i] == '0' && i % 2 == 0)
            countE0.push_back(i);
        else if (s[i] == '0' && i % 2 != 0)
            countO0.push_back(i);
        else if (s[i] == '1' && i % 2 == 0)
            countE1.push_back(i);
        else if (s[i] == '1' && i % 2 != 0)
            countO1.push_back(i);
    }
    int i = 0, j = 0;
    vi swap0, swap1, swap;
    while (i < countE1.size() && j < countO0.size() && countE1.size() != 0 && countO0.size() != 0)
    {

        if (countE1[i] > countO0[j])
        {
            swap.push_back(countE1[i]);
            swap.push_back(countO0[j]);
            swap0.push_back(j);
            swap1.push_back(i);
            i++;
            j++;
        }
        if (countE1[i] < countO0[j])
        {
            i++;
        }
    }
    i = 0, j = 0;

    while (i < countO1.size() && j < countE0.size() && countE0.size() != 0 && countO1.size() != 0)
    {

        if (countO1[i] > countE0[j])
        {
            swap.push_back(countO1[i]);
            swap.push_back(countE0[j]);
            swap0.push_back(j);
            swap1.push_back(i);
            i++;
            j++;
        }
        if (countO1[i] < countE0[j])
        {
            i++;
        }
    }
    if (swap.size() != 0)
    {
        sort(swap.begin(), swap.end());

        int k = 0;

        FOR(i, 0, n)
        {
            if (swap[k] == i)
            {
                s[i] = '-';
                k++;
            }
        }

        string res = "";
        FOR(i, 0, swap0.size())
        {
            res += '0';
        }
        FOR(i, 0, n)
        {
            if (s[i] != '-')
            {
                res += s[i];
            }
        }
        FOR(i, 0, swap1.size())
        {
            res += '1';
        }
        string out = rec(n, res, org);
        return out;
    }
    return org;
}

void solve()
{
    int n;
    cin >> n;
    string s;
    cin >> s;
    if (s.length() == 1)
        cout << s;
    else if (s.length() == 2 && s[0] == '1')
        cout << s;
    else
    {
        cout << rec(n, s, "");
    }
    nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
    return 0;
}