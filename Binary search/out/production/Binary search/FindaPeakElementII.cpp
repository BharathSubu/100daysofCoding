// https://leetcode.com/problems/find-a-peak-element-ii/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

// vector<int> findPeakGrid(vector<vector<int>> &mat)
// {
//     vi arr = {-1, -1};
//     int rows = mat.size();
//     int cols = mat[0].size();
//     FOR(row, 0, rows)
//     {
//         int start = 0, end = cols;
//         while (start <= end)
//         {
//             int mid = start + (end - start) / 2;
//             if ((mid - 1) < 0 && mat[row][mid] > mat[row][mid + 1])
//             {
//                 if (checktopdown(mat, row, mid))
//                 {
//                     arr[0] = row;
//                     arr[1] = mid;
//                     nl;
//                     return arr;
//                 }
//                 else
//                 {
//                     if ((mid - 1) < 0 && mat[row][mid] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else if (mat[row][mid - 1] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else
//                     {
//                         end = mid - 1;
//                     }
//                 }
//             }
//             else if ((mid + 1) > cols - 1 && mat[row][mid] > mat[row][mid - 1])
//             {
//                 if (checktopdown(mat, row, mid))
//                 {
//                     arr[0] = row;
//                     arr[1] = mid;
//                     nl;
//                     return arr;
//                 }
//                 else
//                 {
//                     if ((mid - 1) < 0 && mat[row][mid] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else if (mat[row][mid - 1] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else
//                     {
//                         end = mid - 1;
//                     }
//                 }
//             }
//             else if (mid - 1 >= 0 && mid + 1 < cols && mat[row][mid] > mat[row][mid - 1] && mat[row][mid] > mat[row][mid + 1])
//             {
//                 if (checktopdown(mat, row, mid))
//                 {
//                     arr[0] = row;
//                     arr[1] = mid;
//                     nl;
//                     return arr;
//                 }
//                 else
//                 {
//                     if ((mid - 1) < 0 && mat[row][mid] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else if (mat[row][mid - 1] < mat[row][mid + 1])
//                     {
//                         start = mid + 1;
//                     }
//                     else
//                     {
//                         end = mid - 1;
//                     }
//                 }
//             }
//             else if ((mid - 1) < 0 && mat[row][mid] < mat[row][mid + 1])
//             {
//                 start = mid + 1;
//             }
//             else if (mat[row][mid - 1] < mat[row][mid + 1])
//             {
//                 start = mid + 1;
//             }
//             else
//             {
//                 end = mid - 1;
//             }
//         }
//     }
//     return arr;
// }

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

bool checktopdown(vvi mat, int r, int c)
{
    int rows = mat.size();
    int cols = mat[0].size();
    if (r == 0 && mat[r][c] > mat[r + 1][c])
    {
        return true;
    }
    else if (r == rows - 1 && mat[r][c] > mat[r - 1][c])
    {
        return true;
    }
    else if (mat[r][c] > mat[r + 1][c] && mat[r][c] > mat[r - 1][c])
    {
        return true;
    }
    else
    {
        return false;
    }
}
vector<int> findPeakGrid(vector<vector<int>> &mat)
{
    vi arr = {-1, -1};
    int rows = mat.size();
    int cols = mat[0].size();
    int start = 0, end = rows - 1;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        int maxpos = distance(mat[mid].begin(), max_element(mat[mid].begin(), mat[mid].end()));
        if (checktopdown(mat, mid, maxpos))
        {
            arr[0] = mid;
            arr[1] = maxpos;
            return arr;
        }
        if (mat[mid][maxpos] < mat[mid + 1][maxpos])
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return arr;
}

int main()
{

    vvi arr = {{11, 77, 6, 56, 95, 42, 78, 33, 4, 12, 30, 87, 74, 76, 3, 98},
               {87, 35, 74, 6, 98, 97, 23, 61, 67, 84, 57, 36, 24, 75, 56, 82},
               {63, 12, 61, 45, 53, 43, 42, 86, 14, 21, 43, 53, 89, 64, 37, 85},
               {52, 98, 71, 5, 59, 12, 41, 33, 42, 15, 99, 52, 66, 1, 85, 70},
               {60, 53, 7, 25, 67, 47, 80, 97, 64, 81, 57, 98, 7, 27, 35, 71},
               {17, 37, 57, 90, 63, 16, 4, 81, 78, 31, 91, 21, 40, 71, 2, 53},
               {12, 29, 15, 60, 16, 83, 20, 64, 92, 38, 66, 91, 35, 54, 62, 61},
               {32, 59, 71, 19, 50, 25, 77, 66, 96, 18, 9, 36, 99, 44, 65, 35},
               {1, 37, 93, 39, 76, 75, 85, 63, 20, 58, 69, 62, 45, 43, 71, 98},
               {70, 49, 59, 42, 25, 90, 31, 74, 50, 30, 100, 53, 6, 41, 96, 61},
               {91, 50, 85, 84, 20, 64, 5, 17, 65, 76, 43, 13, 57, 13, 68, 59},
               {2, 93, 19, 53, 84, 20, 10, 61, 34, 44, 80, 89, 51, 84, 11, 43},
               {87, 69, 49, 41, 81, 92, 98, 63, 70, 5, 9, 31, 81, 88, 37, 30},
               {96, 12, 56, 13, 98, 82, 91, 13, 57, 22, 89, 39, 4, 6, 42, 8},
               {38, 46, 48, 56, 19, 32, 68, 53, 73, 88, 24, 22, 23, 11, 79, 49},
               {80, 88, 31, 64, 75, 19, 30, 60, 82, 33, 59, 33, 86, 2, 60, 37},
               {87, 70, 21, 10, 57, 45, 76, 39, 55, 89, 33, 59, 39, 26, 50, 62}};
    vi res = findPeakGrid(arr);
    cout << res[0] << " " << res[1];
};
