// https://practice.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int findKRotation(int arr[], int n)
{
	int start = 0, end = n - 1;
	if(n==1) return 0;
    if (arr[start] < arr[end])
    {
        return 0;
    }

    if (arr[0] > arr[1])
        return 1;

    while (start < end)
    {
        int mid = start + (end - start) / 2;
    
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid-1])
        {
            return mid + 1;
        }
        if(arr[mid] > arr[start]){
             start = mid + 1;
        }
        else
        {
            end = mid  ;
        }
    }
    return -1 ;
}

int main()
{

    int arr[] = {6,7,8, 1, 2, 3};
    int n = sizeof(arr) / sizeof(arr[0]);
    int idx = findKRotation(arr, n);
    cout << idx;
}