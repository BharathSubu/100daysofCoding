// Program to generate Pascal’s Triangle
// Problem Statement: Given an integer N, return the first N rows of Pascal’s triangle.

// In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:


// Example 1:

// Input Format: N = 5

// Result:
//     1
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1

// Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
// Example 2:

// Input Format: N = 1

// Result: 
//     1


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
    int n;
    cin >> n;
    vvi pas(n);
    FOR(i,0,n){
        vi tri(i+1);
        FOR(j,0,i+1){
            if(j==0 || j== i){
                tri[j] = 1;
            }
            else{
                tri[j] =  pas[i-1][j] + pas[i-1][j-1];
            }
        }
        pas[i] = (tri);
    }
    int space = n-1;
   FOR(i,0,n){ 
    FOR(k,0,space) cout<<" ";
    space--;
    FOR(j,0,pas[i].size()) {cout<<pas[i][j]<<" ";}
     nl;
   }
}

int main()
{
    solve();
}