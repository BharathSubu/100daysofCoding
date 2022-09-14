// Count the number of subarrays with given xor K
// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to B.

// Examples:

// Input Format:  A = [4, 2, 2, 6, 4] , B = 6
// Result: 4
// Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

// Input Format: A = [5, 6, 7, 8, 9], B = 5
// Result: 2
// Explanation:The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int solve(vector<int> &A, int B)
{
    int total = 0;
    unordered_map<int, int> visited;
    int prexor = 0;
    FOR(i, 0, A.size())
    {
        prexor ^= A[i];
        if (prexor == B)
            total++;
        int ispresent = prexor ^ B;
        if (visited.find(ispresent) != visited.end())
        {
            total += visited[ispresent];
        }
        visited[prexor]++;
    }
    return total;
}

int main()
{
    vi A = {4, 2, 2, 6, 4};
    int b = 6;
    int total = solve(A, b);
    cout << total;
}