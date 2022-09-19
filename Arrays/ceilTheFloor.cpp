
//practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%3BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array

 
 
#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

pair<int, int> getFloorAndCeil( int arr[], int n,  int x) {
    pair<int,int> res;
    sort((arr), arr + n);
    int floor = - 2 ; int ceil = -2;
    ll start = 0 , end = n -1;
    ll left = -1;
   

    while(start<=end ){
        ll mid = start + (end-start)/2;
        if(arr[mid]==x || x > arr[mid-1] && x < arr[mid]){
            left = mid;
            break;
        }
        else if (arr[mid] > x)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
     if( arr[left] == x ){ floor =  left ; ceil = left;}
     else if(left == 0  ) {floor =  -1 ; ceil = 1;};
     if( floor == -2)  floor = left -1;
     if( ceil == -2)  ceil = left;
     if(x > arr[n-1]  ) floor = n-1;
    if(x > arr[n-1]) ceil = -1;

    if(x < arr[0] ) floor =  -1;
    if(x < arr[0]) ceil =  0;
    if(floor == -1) res.first = -1;
    else res.first =arr[floor];
    if(ceil == -1) res.second = -1;
    else res.second =arr[ceil];

     return res;
}

int main()
{
   int arr[] = {65 ,63 ,39, 57 ,9 ,29};
    ll n = sizeof(arr)/sizeof(arr[0]);
   pair<int, int> occ ; occ = getFloorAndCeil(arr,n,4);
   cout<<occ.first <<" "<<occ.second;

}