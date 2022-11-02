// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/?envType=study-plan&id=binary-search-ii

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>

bool iscovered(vi dist , double hour , int speed ){
      double time = 0;
        for (int i = 0; i < dist.size() - 1; ++i)
            time += ((dist[i] + speed - 1) / speed);
        
        time += ((double)dist.back()) / speed;
        return time <= hour;
}

int minSpeedOnTime(vector<int> &dist, double hour)
{
    int end = 1e7;
    int n = dist.size();
    int start = 1;
    int res = -1;
    while (start<=end)
    {
        int mid = start + (end - start)/2;
        cout<<mid;nl;
        if(iscovered(dist,hour ,mid)){
            res = mid;
            end = mid -1;
        }
        else{
            start = mid +1;
        }
    }
    return res;

}

int main()
{

   vi dist = {1,1,10000000}; float hour = 2.01;
   cout<<minSpeedOnTime(dist , hour);

}
