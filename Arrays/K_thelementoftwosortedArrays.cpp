// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
int kthElement(int arr1[], int arr2[], int n, int m, int k)
{
    int start1 = 0, end1 = n - 1, start2 = 0, end2 = m - 1;
    int num = -1;
    while (start1 <= end1 && start2 <= end2)
    {
        int mid1 = start1 + (end1 - start1) / 2;
        int mid2 = start2 + (end2 - start2) / 2;
        int elementsbehind =n-mid1 + m-mid2 -2 ;
        if(elementsbehind == m+n-k) {
            
            int mid = arr1[mid1] > arr2[mid2] ? mid2 : mid1;
            if(arr1[mid] == arr1[mid1])
            FORD(i,mid,0){
                if()
            }
            else{
                
            }
            return num; 
        }
        else{
            if(elementsbehind < k - 1){
            cout<<mid1<<" "<<mid2 <<" "<<arr1[mid1] <<" "<< arr2[mid2]<<" ";nl;

                if(arr1[mid1] > arr2[mid2]){
                    start2 = mid2 + 1;
                }
                else{
                    start1 = mid1 + 1;
                }
            }
            else{
                if(elementsbehind > k - 1){
                cout<<mid1<<" "<<mid2 <<" "<<arr1[mid1] <<" "<< arr2[mid2]<<" ";nl;
                if(arr1[mid1] > arr2[mid2]){
                    end1 = mid1 - 1;
                }
                else{
                    end2 = mid2 - 1;
                }
             }
            }
        }
    }
    cout<<start1<<" "<<end2<<" "<<start2<<" "<<end2;
    return 1;
}
int main()
{

    int arr1[] = {100, 112, 256, 349, 770};
    int arr2[] = {72, 86, 113, 119, 265, 445, 892};
    int n = sizeof(arr1) / sizeof(arr1[0]);
    int m = sizeof(arr2) / sizeof(arr2[0]);
    int k = 7;
    int num = kthElement(arr1, arr2, n, m, 8);
    cout << num;
}