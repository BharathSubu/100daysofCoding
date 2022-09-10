// Sort an array of 0s, 1s and 2s
// Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Input: nums = [2,0,1]
// Output: [0,1,2]

// Input: nums = [0]
// Input: nums = [0]

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
   vi nums ={2,0,2,1,1,0};
   int count0 = 0 ; int count1 = 0; int count2 = 0;
   FOR(i,0,nums.size()){
      if(nums[i] == 0 ) count0++;
      else if(nums[i] == 1) count1++;
      else count2++;  
   }
   int i = 0;
   cout<<count0<<" "<<count1<<" "<<count2;nl;
   while ( count0 != 0 || count1 != 0 || count2 !=0){
       if(count0 > 0){
         nums[i] = 0;
         i++;
         count0--;
         continue;
       }
       if(count1 > 0){
         nums[i] = 1;
         i++;
         count1--;
         continue;
       }
       if(count2 > 0){
         nums[i] = 2;
         i++;
         count2--;
         continue;
       }
       
   }
  
    FOR(i,0,nums.size())cout<<nums[i]<<" ";
}
int main()
{
    solve();
}