// https://leetcode.com/problems/remove-outermost-parentheses/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

string removeOuterParentheses(string s)
{
    int n = s.length();
    pair<char, int> paran;
    paran.first = '(';
    paran.second = 0;
    int start = 0;
    vi removearr;

    FOR(i, 0, n)
    {
        if (s[i] == '(')
        {
            paran.second++;
        }
        else
        {
            paran.second--;
            if (paran.second == 0)
            {
                removearr.push_back(start);
                removearr.push_back(i);
                start = i + 1;
            }
        }
    }
    int k = 0;
    string res = "";

    FOR(i, 0, n)
    {
        if (i == removearr[k])
        {
            k++;
        }
        else
        {
            res += s[i];
        }
    }
    return res;
}

int main()
{

    string s = "(()())(())(()(()))";
    cout << removeOuterParentheses(s);
}