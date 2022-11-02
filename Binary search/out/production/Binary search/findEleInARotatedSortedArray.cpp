// https://leetcode.com/problems/find-peak-element/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int search(vector<int> &nums, int target)
{
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
        cout<<peak<<endl;   
        if(nums[peak]==target){ return peak;}
        start = 0 ; end = peak; 
        
        while(start<=end){
            mid=start + (end - start)/2;
            if(nums[mid] == target){
                return  mid;
            }
            if(nums[mid] > target ){
                end = mid - 1;
            }
            else{
                start = mid + 1;    
            }
         
        }
       
        start = peak + 1 ; end = n -1;
        while(start<=end){
            mid=start + (end - start)/2;
            if(nums[mid] == target){
             return mid;
            }
            if(nums[mid] > target ){
                end = mid - 1;
            }
            else{
                start = mid + 1;    
            }
            }
           
    return -1;
}

int main()
{
    vi arr = {5,1,2,3,4};
    int idx = search(arr, 1);
    cout << idx;
}