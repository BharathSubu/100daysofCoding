// https://leetcode.com/problems/valid-anagram

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

bool isAnagram(string s, string t)
{
    if(t.length() != s.length()) return  false;
    unordered_map<char, int> map;
    FOR(i,0,s.length()){
        if(map.find(s[i]) != map.end()){
            map[s[i]]+=1;
        }
        else
        map[s[i]]++;
    }
    FOR(i,0,t.length()){
        if(map.find(t[i]) != map.end()){
            map[t[i]]-=1;
        }
        else return false;
    }
    FOR(i,0,t.length()){
       if(map[t[i]] != 0) return false;
    }
    
    return true;
   
}
int main()
{

    string s = "rac", t = "car";
    cout << isAnagram(s, t);
}