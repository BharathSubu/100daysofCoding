// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vs vector<string>
#define vvi vector<vector<int>>

int garbageCollection(vector<string> &garbage, vector<int> &travel)
{
    FOR(i,1,travel.size()){
        travel[i]+=travel[i-1];
        
    }
    int g = 0;
    int p = 0;
    int m = 0;
    int pickuptime =0;
    FOR(i,0,garbage.size()){
        for(char c : garbage[i]){
            if(c == 'G') g = i;
            if(c == 'P') p = i;
            if(c == 'M') m = i;
        }
        pickuptime+=garbage[i].size();
    }
    int traveltime = 0;
    if(g>=1) traveltime+=travel[g-1];
    if(p>=1) traveltime+=travel[p-1];
    if(m>=1) traveltime+=travel[m-1];

    return traveltime+pickuptime;

}
int main()
{
    vs garbage = {"MMM","PGM","GP"}; 
    vi travel = {3,10};
    cout << garbageCollection(garbage,travel);
}