// https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int beautySum(string s)
{
    int n = s.size();
    int count = 0;
    FOR(i, 0, n)
    {
        unordered_map<char, int> map;

        FOR(j, i, n)
        {
            map[s[j]]++;
            int l = INT_MAX, mm = INT_MIN;

            for (auto it : map)
            {
                l = min(l, it.second);
                mm = max(mm, it.second);
            }
            count += (mm - l);
        }
    }

    return count;
}
int main()
{

    string s = "xzvfsppsjfbxdwkqe";
    cout << beautySum(s);
}