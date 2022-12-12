// https://leetcode.com/problems/subarrays-with-k-different-integers/

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



int deleteGreatestValue(vector<vector<int>>& grid) {
    int maximum = INT_MIN;
    int res = 0;
    for (int i = 0; i < grid[0].size; i++)
    {
        for (int j = 0; j < grid.size; j++)
        {
            int index = distance(grid[j].begin(), max_element(grid[j].begin(), grid[j].end()));
            maximum =   max(maximum,grid[j][index]);
            grid[j].erase(grid[j].begin() + index);
        }
        res+=maximum;
    }
    return res;
    
}

int main()
{

    vvi grid ={{9,81},{33,17}};
    int k = 2;
    cout << deleteGreatestValue(grig);
}