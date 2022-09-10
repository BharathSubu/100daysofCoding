// Rotate Image by 90 degree
// Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

// Note: Rotate matrix 90 degrees anticlockwise

// Examples:

// Example 1:

// Input: [[1,2,3],[4,5,6],[7,8,9]]

// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

// Example 2:

// Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

// Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

// Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORE(a, b, c) for (int(a) = (b); (a) <= (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define all(X) (X).begin(), (X).end()
#define vi vector<int>
#define vvi vector<vector<int>>
#define vl vector<ll>
#define vd vector<double>

void solve()
{
    vvi matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int n = matrix.size();
    vi arr(n * n);
    int k = 0;
    FOR(j, 0, n)
    FORD(i, n - 1, 0)
    {
        arr[k] = matrix[i][j];
        k++;
    }
    k = 0;
    FOR(i, 0, n)
    FOR(j, 0, n)
    {
        matrix[i][j] = arr[k];
        k++;
    }
    FOR(i, 0, n)
    FOR(j, 0, n) { cout << matrix[i][j] << " "; }
}
int main()
{
    solve();
}