// https://leetcode.com/problems/maximum-number-of-removable-characters/?envType=study-plan&id=binary-search-ii

#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>

bool isSubsequence(string s, string p, vector<int> &removable, int mid)
{
    string comp = s;
    FOR(i, 0, mid + 1)
    {
        comp[removable[i]] = '-';
    }
    // cout << mid << " " << comp << " " << p;
    // nl;
    int k = 0;
    FOR(i, 0, s.length())
    {
        if (comp[i] == p[k])
        {

            k++;
        }
        if (k == p.length())
            return true;
    }
    return false;
}

int maximumRemovals(string s, string p, vector<int> &removable)
{
    if (s.length() < p.length())
        return false;
    int rn = removable.size();
    int start = 0, end = rn - 1;
    int res = 0;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (isSubsequence(s, p, removable, mid))
        {
            res = mid + 1;

            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return res;
}

int main()
{
    string s = "abcab", p = "abc";
    vi removable = {0, 1, 2, 3, 4};
    cout << maximumRemovals(s, p, removable);
    nl;
};
