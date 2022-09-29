// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vs vector<string>
#define pb push_back
#define vvi vector<vector<int>>
#define umap unordered_map

int maxDepth(string s)
{
    int inner = INT_MIN;
    int pos = 0;
    FOR(i, 0, s.size())
    {
        if (s[i] == '(')
        {
            pos++;
        }
        if (s[i] == ')')
        {
            pos--;
        }
        inner = max(pos, inner);
    }
    return inner;
}
int main()
{
    string s = "(1)+((2))+(((3)))";
    cout << maxDepth(s);
}