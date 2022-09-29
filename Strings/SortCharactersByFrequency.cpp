// https://leetcode.com/problems/sort-characters-by-frequency/

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vi vector<int>
#define vs vector<string>
#define pb push_back
#define vvi vector<vector<int>>
#define umap unordered_map

string frequencySort(string s)
{
    umap<char, int> map;
    FOR(i, 0, s.length())
    {
        map[s[i]]++;
    }
    string res = "";
    vector<pair<int, char>> A(map.size());
    for (auto it : map)
    {
        A.push_back({it.second, it.first});
    }
    sort(A.rbegin(), A.rend());

    for (auto x : A)
    {
        FOR(i, 0, x.first)
        res += x.second;
    }
    return res;
}

int main()
{

    string s = "eeeeaaarrd";
    cout << frequencySort(s);
}