// Problem Statement: Given a matrix m X n, count paths from left-top to the right bottom of a matrix with the constraints that from each cell you can either only move to the rightward direction or the downward direction.
// Example 1:

// Input Format: m = 2, n= 2
// Output: 2
// Explanation: From the top left corner there are total 2 ways to reach the bottom right corner:

// Step 1: Right ->> Down

// Step 2: Down ->> Right

// Example 2:

// Input Format: m = 2, n= 3
// Ouput: 3
// Explanation:  From the top left corner there is a total of 3 ways to reach the bottom right corner.

// Step 1: Right ->> Right ->> Down

// Step 2: Right ->> Down ->> Right

// Step 3: Down ->> Right->> Right

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

int row, col;

int solve(vvi matrix, int curri, int currj)
{
    int count = 0;
    if (curri == row - 1 && (currj == col - 1))
        return 1;
    else
    {
        if (curri + 1 < row && currj < col && matrix[curri][currj] == -1)
        {
            count += solve(matrix, curri + 1, currj);
        }
        if (curri < row && currj + 1 < col && matrix[curri][currj] == -1)
        {
            count += solve(matrix, curri, currj + 1);
        }
        if (matrix[curri][currj] == -1)
            matrix[curri][currj] = count;
        else
            count = matrix[curri][currj];
    }
    return count;
}
int main()
{
    row = 3;
    col = 7;
    vi cols(col, -1);
    vvi matrix(row, cols);
    int unique = solve(matrix, 0, 0);
    cout << unique;
}