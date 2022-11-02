// https://leetcode.com/problems/spiral-matrix/submissions/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

vector<int> spiralOrder(vector<vector<int>> &matrix)
{
    int n = matrix.size();
    int m = matrix[0].size();
    vi v(m, -1);
    vvi visitedmatrix(n, v);
    vi result;
    int pos = 0;

    int top = 0, right = m - 1, left = 0, down = n - 1;
    int count = n * m;

    while (count > 0)
    {
        // move right

        for (int i = top; i <= right; i++)
        {
            if (visitedmatrix[top][i] == -1)
            {
                result.insert(result.begin() + pos, matrix[top][i]);
                visitedmatrix[top][i] = 0;
                count--;
                pos++;
            }
        }

        // move down
        for (int i = top; i <= down; i++)
        {

            if (visitedmatrix[i][right] == -1)
            {
                result.insert(result.begin() + pos, matrix[i][right]);

                visitedmatrix[i][right] = 0;
                count--;
                pos++;
            }
        }

        // move left
        for (int i = right; i >= left; i--)
        {
            if (visitedmatrix[down][i] == -1)
            {
                result.insert(result.begin() + pos, matrix[down][i]);

                visitedmatrix[down][i] = 0;
                count--;
                pos++;
            }
        }

        // move up
        for (int i = down; i >= top; i--)
        {
            if (visitedmatrix[i][top] == -1)
            {
                result.insert(result.begin() + pos, matrix[i][top]);

                visitedmatrix[i][top] = 0;
                count--;
                pos++;
            }
        }

        top++;
        right--;
        down--;
        left++;
    }

    return result;
}

int main()
{
    vvi matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    vi arr(matrix.size() * matrix.size());
    arr = spiralOrder(matrix);
    FOR(i, 0, arr.size())
    cout << arr[i] << " ";
}