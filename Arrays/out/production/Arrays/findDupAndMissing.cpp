// Find the repeating and missing numbers
// Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

// Example 1:
// Input Format:  array[] = {3,1,2,5,3}

// Result: {3,4)

// Explanation: A = 3 , B = 4
// Since 3 is appearing twice and 4 is missing

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vector<int> solve(vector<int> &A)
{
    vector<int> res = {0, 0};
    vector<int> checkdupe(A.size(), -1);
    for (int i = 0; i < A.size(); i++)
    {
        if (checkdupe[A[i] - 1] == -1)
        {
            checkdupe[A[i] - 1] = 0;
        }
        else
            res[0] = A[i];
    }
    for (int i = 0; i < A.size(); i++)
    {
        if (checkdupe[i] == -1)
            res[1] = i + 1;
    }
    return res;
}

int main()
{
    vector<int> A = {3, 1, 2, 4, 3};
    vector<int> res = solve(A);
    cout << res[0] << " " << res[1];
}