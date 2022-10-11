// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

ll findInsert( vi nums , ll start ,ll end , ll num){

    if(num < nums[start]) return start;
    ll mid = (start + end)/2;
    
    while (start<=end)
    {
       mid = (start + end)/2;
       if(mid >= start && num > nums[mid] && num < nums[mid+1]) return mid + 1;
       else if(mid <= end && num < nums[mid] && num > nums[mid-1]) return mid;

       if(mid<=end && nums[mid] == nums[mid - 1]) end = mid - 1;
       else if(mid >=start && nums[mid] == nums[mid + 1]) end = mid - 1;

       else if(nums[mid] > num ) end = mid -1;
       else start = mid + 1; 
    }

    return start;
}

int findUnsortedSubarray(vector<int> &nums)
{
    ll n = nums.size();
    ll start = 0, end = 0;
    FOR(i,0,n-1){
    if(nums[i] > nums[i+1]){
        start = findInsert(nums,0,i,nums[i+1]);
        break;
    }
    }
    FORD(i,n-1,1){
        if(nums[i] < nums[i-1]){
            end = findInsert(nums , i-1 , n - 1 , nums[i-1]);
            break;
        }
    }
    cout<<start<<" "<<end;nl;
    return end - start;
}

int main()
{
    vi nums = {1,3,2,3,3};
    int total;
    total = findUnsortedSubarray(nums);
    cout << total;
}