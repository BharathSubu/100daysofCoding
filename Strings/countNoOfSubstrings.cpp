// https://practice.geeksforgeeks.org/problems/count-number-of-substrings

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

long long int substrCount(string s, int k)
{
    int n = s.size();
    int count = 0;
    unordered_map<char, int> map;
    FOR(i, 0, n)
    {
        map[s[i]]++;
    }

    return count;
}
int main()
{

    string s = "aba";
    cout << substrCount(s,2);
}