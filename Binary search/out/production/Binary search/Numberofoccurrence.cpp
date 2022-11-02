//https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence

 

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int count(int arr[], int n, int x) {

    int start = 0 , end = n -1;
    int left = -1;
    while(start<=end){
        
        int mid = (start+end)/2;
        if(arr[mid]==x){
            left = mid;
            end = mid -1 ;
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

     start = 0 ; end = n -1;
    int right = -1;
    while(start<=end){
        int mid = (start+end)/2;
        if(arr[mid]==x){
            right = mid;
            start = mid + 1 ;
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
    if(left != -1)
	return right - left + 1;
    else return 0;
}
int main()
{
    int arr[] = {1, 1, 2, 2, 3 , 3,3};
    int n = sizeof(arr)/sizeof(arr[0]);
    int occ = count(arr,n,3);
    cout<<occ;
}