// https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/

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

long long int substrCount(string s, int k)
{
   int n = s.size();
    unordered_map<char, int> map;
    vc arr;
    int count = 0;
    int totalsub = 0;
    int jx = 0;
    FOR(i, 0, n)
    {
        if (map.find(s[i]) == map.end() )
        {
            arr.pb(s[i]);
            count++;
        }
        map[s[i]]++;
        if (count == k )
        {
            totalsub+= map[arr[jx]] ;
        }
        else if (count > k)
        {
            count--;
            if(s[i] == arr[jx]) totalsub++;
            else totalsub+=map[arr[jx]];
            map.erase(arr[jx]);
            jx++;
        }
    }
    return totalsub;
}
int main()
{

    string s = "umeaylnlfd";
    cout << substrCount(s,2);
}