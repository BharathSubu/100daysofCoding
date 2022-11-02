//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

 
 
#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

 vector<int> searchRange(vector<int>& nums, int target) {

    vi arr;
    int start = 0 , end = nums.size() -1;
    int left = -1;
    while(start<=end){
        int mid = (start+end)/2;
        if(nums[mid]==target){
            left = mid;
            end = mid -1 ;
        }
        else if (nums[mid] > target)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }

     start = 0 ; end = nums.size() -1;
    int right = -1;
    while(start<=end){
        int mid = (start+end)/2;
        if(nums[mid]==target){
            right = mid;
            start = mid + 1 ;
        }
        else if (nums[mid] > target)
        {
            end = mid - 1;
        }
        else
        {
            start = mid + 1;
        }
    }
    arr.push_back(left);
    arr.push_back(right);
    return arr;

}
int main()
{
    vi nums = {1, 1, 2, 2, 3 , 3,3};
    vi arr ;
    arr = searchRange(nums,3);
    cout<<arr[0]<<" "<<arr[1];
}