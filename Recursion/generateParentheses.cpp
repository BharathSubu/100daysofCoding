// https://leetcode.com/problems/generate-parentheses/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
#define vs vector<string>

vs res = {};
vector<string> generateParenthesis(int n, string s = "", int open = 0, int close = 0, int len = 0)
{
       
    if (open == 0)
    {
        s += '(';
        open++;
        len++;
    }
    if (close == n || len == 2*n)
    {
        
        res.push_back(s);
        return res;
    }

    if (open < n && open >= close)
    {
        string prev = s;
        s += '(';
        open++;
        len++;
        generateParenthesis(n, s, open, close, len);
        s = prev;
        open--;
        len--;
    }
    if (open > close )
    {
        s += ')';
        close++;
        len++;
        generateParenthesis(n, s, open, close, len);
       
    }
    return res;
}

int main()
{
    int n = 3;
    vs result = generateParenthesis(n);
    FOR(i, 0, result.size())
    {
        cout << res[i] << ' ';
    }
}