// https://leetcode.com/problems/incremental-memory-leak/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vector<int> memLeak(int memory1, int memory2)
{
    vector<int> arr = {0, 0, 0};
    int time = 1;
    while (1)
    {
        if (memory1 >= memory2)
        {
            memory1 -= time;
        }
        else
        {
            memory2 -= time;
        }
        if (memory1 < 0 || memory2 < 0)
            break;
        time++;
    }
    arr[0] = time;
    arr[1] = memory1 < 0 ? memory1 + time : memory1;
    arr[2] = memory2 < 0 ? memory2 + time : memory2;
    return arr;
}
int main()
{
    int n = 12;
    cout << concatenatedBinary(n);
}