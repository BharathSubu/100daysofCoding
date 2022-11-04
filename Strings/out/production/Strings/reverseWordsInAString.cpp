// https://leetcode.com/problems/reverse-words-in-a-string/

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

string reverseWords(string s)
{
    int n = s.length();
    vs words;
    char prev = ' ';
    int start = 0;
    FOR(i, 0, n)
    {
        if (s[i] != ' ' && prev == ' ')
        {
            start = i;
        }
        if (s[i] == ' ' && prev != ' ')
        {

            string word = s.substr(start, i - start);

            words.pb(word);
        }
        if (i == n - 1 && s[i] != ' ')
        {

            string word = s.substr(start, i - start + 1);

            words.pb(word);
        }
        prev = s[i];
    }
    string res = "";
    FORD(i, words.size() - 1, 0)
    {
        res += words[i];
        if (i != 0)
            res += " ";
    }
    return res;
}

int main()
{

    string s = "  the    sky is blue  ";
    cout << reverseWords(s) << ;
}