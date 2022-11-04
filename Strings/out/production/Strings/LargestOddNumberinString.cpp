// https://leetcode.com/problems/largest-odd-number-in-string/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

string largestOddNumber(string num)
{
    int n = num.length();
    int end;
    FORD(i, n - 1, 0)
    {
        if (num[i] % 2 != 0)
        {
            end = i;
            break;
        }
    }
    return num.substr(0, end + 1);
}

int main()
{

    string s = "42046838026";
    cout << largestOddNumber(s);
}