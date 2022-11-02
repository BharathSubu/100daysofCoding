// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int minPartitions(string s)
{
    int n = s.size();
    int max = 0;
    FOR(i, 0, n)
    {
        if (s[i] - '0' > max)
        {
            max = s[i] - '0';
        }
    }
    return max;
}

int main()
{
    string s = "27346209830709182346";
    cout << minPartitions(s);
}