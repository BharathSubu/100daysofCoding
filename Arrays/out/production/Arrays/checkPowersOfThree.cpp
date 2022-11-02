// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

ll findpower(int n , ll start , ll end){

    while(start<=end){
        ll mid = (start + end)/2;
        ll  midpow = pow(3,mid);
        ll left = pow(3,mid - 1);
        ll right = pow(3,mid + 1);
        if(midpow == n) return mid;
        else if(left  < n && right > n) return mid ;
        else if(midpow < n) start = mid + 1;
        else end = mid -1;
    }
    return -1;
}

bool checkPowersOfThree(int n)
{
   int power = findpower(n,0,16);
   int i  = 0;
   while(n> 0){
      if(power-i<0) return false;
      int newn = n - pow(3,power-i);
      if(newn >= 0) n = newn;
      i++;
   }
   return true;  
}

int main()
{
    int n = 36;
    cout << checkPowersOfThree(n) ;
}