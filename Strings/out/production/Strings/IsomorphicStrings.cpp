//https://leetcode.com/problems/isomorphic-strings/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

bool isIsomorphic(string s, string t) {
    if(s.length() != t.length()) return false;
      unordered_map <char , int>  map;
      string numstr1 = "";
      FOR(i,0,s.length()){
        if(map.find(s[i]) == map.end())
            map[s[i]]=i;
        char c = '0' + map[s[i]];
        numstr1+=c;
      }
      string numstr2 = "";
      unordered_map <char , int>  map2;

      FOR(i,0,t.length()){
        if(map2.find(t[i]) == map2.end())
            map2[t[i]]=i;
        char c = '0' + map2[t[i]];
        numstr2+=c;
      }
      cout<<numstr1<<" "<<numstr2;nl;
      return numstr1 == numstr2;
}

int main()
{

    string s = "foo", t = "bar";
    cout << isIsomorphic( s,  t);
}