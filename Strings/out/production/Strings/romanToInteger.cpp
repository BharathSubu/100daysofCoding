// https://leetcode.com/problems/roman-to-integer/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int romanToInt(string s)
{
    unordered_map<char,int> roman;
    roman['I'] = 1;
    roman['V'] = 5;
    roman['X'] = 10;
    roman['L'] = 50;
    roman['C'] = 100;
    roman['D'] = 500;
    roman['M'] = 1000;
    int n = s.size();
    int num  = roman[s[n-1]];
    FORD(i,n-2,0){
        if(roman[s[i+1]] > roman[s[i]]) num -= roman[s[i]];
        else num+=roman[s[i]];
    }
    return num;
}

int main()
{

    string s = "MCMXCIV";
    cout << romanToInt(s);
}