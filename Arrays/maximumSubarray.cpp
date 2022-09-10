// Kadane’s Algorithm : Maximum Subarray Sum in an Array
// Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and return its sum and print the subarray.

// Examples:

// Example 1:

// Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 

// Output: 6 

// Explanation: [4,-1,2,1] has the largest sum = 6. 

// Examples 2: 

// Input: arr = [1] 

// Output: 1 

// Explanation: Array has only one element and which is giving positive sum of 1. 


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

void solve(){
    vi nums ={2,-3,5};
    int maxsofar = INT_MIN, maxati = 0;
    for (int i = 0; i < nums.size(); i++) {
        maxati += nums[i];
        if (maxati > maxsofar) {
            maxsofar = maxati;

        }
        if (maxati < 0) {
            maxati = 0;
        }
    }
    cout<<maxsofar;
}
int main()
{
    solve();
}