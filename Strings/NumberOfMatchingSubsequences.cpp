// https://leetcode.com/problems/longest-palindromic-substring/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vc vector<char>
#define pb push_back
#define vvi vector<vector<int>>
#define vs vector<string>

int numMatchingSubseq(string s, vector<string> &words)
{
    unordered_map<char, vi> map;
    int count = 0;
    FOR(i, 0, s.size())
    {
        map[s[i]].push_back(i);
    }
    FOR(i, 0, words.size())
    {
        string word = words[i];
        int isfound = 0;
        int curri = -1;
        FOR(j, 0, word.size())
        {
            auto it = upper_bound(map[word[j]].begin(), map[word[j]].end(), curri);
            if (it == map[word[j]].end())
                break;
            curri = *it;
            if (j == word.size() - 1)
                count++;
        }
    }
    return count;
}

int main()
{

    string s = "abcde";
    vs words = {"ade", "bb", "acd", "ace"};
    cout << numMatchingSubseq(s, words);
}