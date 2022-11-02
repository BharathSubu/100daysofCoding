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

bool solve()
{
    vvi matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

    int target = 3;
    int row = matrix.size(), col = matrix[0].size();

    FOR(i, 0, row)
    {
        int start = matrix[i][0], end = matrix[i][col - 1];
        if (target <= end && target >= start)
        {

            int l = 0, r = col;
            while (l <= r)
            {
                int mid = (l + r) / 2;
                if (matrix[i][mid] == target)
                    return true;
                if (matrix[i][mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
    }
    return false;
}

int main()
{
    if (solve())
        cout << "TRUE";
    else
        cout << "False";
}