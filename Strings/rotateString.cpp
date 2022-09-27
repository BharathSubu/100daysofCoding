// https://leetcode.com/problems/rotate-string/

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

bool rotateString(string s, string goal)
{
    if(s.length() != goal.length()) return false;
    int start = 0;
    int count = 0;
    int k = 0;
    int step = 0;
    FOR(i,0,goal.length()){
        if(goal[i] == s[k]){
             count++;
             k++;
        }
        else{
            i = i - count;
            count = 0;
            k=0;
        }
        step++;
        if(count == goal.length()) return true;
        if(step ==  2 * goal.length()) return false;

        if(i == goal.length() - 1){
            i = -1;
        }
    }
    return false;
}

int main()
{

    string s = "bbbacddceeb", goal = "ceebbbbacdd";
    cout << rotateString(s, goal);
}