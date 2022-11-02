// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int chalkReplacer(vector<int> &chalk, int k)
{
    int n = chalk.size();
    FOR(i, 1, n)
    {
        chalk[i] += chalk[i - 1];
    }
    int target = chalk[n - 1] % k;
    int start = 0, end = n - 1;
    int pos = -1;
    if(target < chalk[0]) return 0;

    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (chalk[mid] == target)
        {
            pos = mid == n - 1 ? 0 : mid + 1;
            return pos;
        }
        else if( chalk[mid] > target) end = mid -1;
        else start = mid + 1; 
    }
    return end;
}

int main()
{

    vi chalk = {3, 4, 1, 2};
    int k = 25;
    int student = chalkReplacer(chalk, k);
    cout << student;
}
