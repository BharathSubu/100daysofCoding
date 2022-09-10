// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

// Examples:

// Examples 1:

// Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 
// Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

// Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0

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

void solve()
{
    vvi matrix {
        {0,1,2,0},
        {3,4,5,2},
        {1,3,1,5}
    };
    int row = matrix.size();
    int col = matrix[0].size();
    vi zero(row , 0);
    set<int> rows;
    set<int> cols;
    FOR(i, 0, row)
    FOR(j, 0, col)
    {
        if (matrix[i][j] == 0)
        {
            rows.insert(i);
            cols.insert(j);
        }
    };
    for (int i : rows)
    {
        matrix[i] = zero;
    }
    for (int i : cols)
    { 
        FOR(j, 0, row)
        matrix[j][i] = 0;
    }
    FOR(i, 0, row)
    FOR(j, 0, col)
    { cout<<matrix[i][j]<<" ";}
}

int main()
{
    solve();
}