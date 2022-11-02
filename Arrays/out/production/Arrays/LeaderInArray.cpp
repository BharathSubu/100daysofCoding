// Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.
// Example 1:

// Input:
// n = 6
// A[] = {16,17,4,3,5,2}
// Output: 17 5 2
// Explanation: The first leader is 17
// as it is greater than all the elements
// to its right.  Similarly, the next
// leader is 5. The right most element
// is always a leader so it is also
// included.

// Example 2:

// Input:
// n = 5
// A[] = {1,2,3,4,0}
// Output: 4 0
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

vector<int> leaders(int a[], int n)
{
    vi arr;
    int leaderNow = INT_MIN;
    FORD(i, n - 1, 0)
    {
        if (a[i] >= leaderNow)
        {
            leaderNow = a[i];
            arr.pb(a[i]);
        }
    }
    reverse(arr.begin(), arr.end());
    return arr;
}
int main()
{
    int a[] = {16, 17, 4, 3, 5, 2};
    vi arr;
    arr = leaders(a, 6);
    FOR(i, 0, arr.size())
    {
        cout << arr[i] << " ";
    }
}