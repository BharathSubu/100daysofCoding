// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int findMin(vector<int>& nums) {
        
   int n = nums.size();
        int start = 0 , end = n - 1;
        int mid ;
        int peak = -1;
        while(start<=end){
        mid=start + (end - start)/2;
        if(start == end){
            peak = start;
            break ;
        }
        if(mid<end && nums[mid]>nums[mid+1]){
            peak = mid;
            break;
        }
        if(nums[start] > nums[mid] ){
            end = mid - 1;
        }
        else{
            start = mid + 1;    
        }
        
        }
       
    if(peak == nums.size()-1) return nums[0];
    return nums[peak+1];
}

int main()
{
    vi arr = {5,6,7,8,1,2,3,4};
    int idx = findMin(arr);
    cout << idx;
}