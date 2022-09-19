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

int findFloor(long long int arr[], int N, long long int x) {

    ll start = 0 , end = N -1;
    ll left = -1;
    if(x > arr[N-1]) return N-1;
    if(x < arr[0]) return -1;
    while(start<=end){
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
     if(left == 0) return -1;
     else if( arr[left] == x) return left;
     return left -1;
}

int main()
{
   ll arr[] = {1,2,8,10,11,12,19};
    ll n = sizeof(arr)/sizeof(arr[0]);
   ll occ = findFloor(arr,n,9);
    cout<<occ;
}