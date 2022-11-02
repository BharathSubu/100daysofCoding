// https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan&id=binary-search-ii

#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>


int b_search(vector<int>& nums, int i, int target) {
        int low = 0;
        int high = i;
        while(low < high) {
            int mid = (low + high + 1) / 2;
            if(nums[i] - nums[mid] >= target) low = mid;
            else high = mid - 1;
        }
        return nums[i] - nums[low] < target ? -1 : low;
    }

int minSubArrayLen(int target, vector<int> &nums)
{
    int n = nums.size();
    int res = INT_MAX;
    vi presum(n+1);
    presum[0] = 0;
    FOR(i,1,n+1){
        presum[i]=nums[i-1]+presum[i-1];
    }
    FOR(i,0,n+1){
        if(presum[i] >= target){
            int j = b_search(presum, i, target);
            if(j != -1)
                    res = min(res, i - j);
        }
    }
    return res;
}

int main()
{

    vi arr = { 2,3,1,2,4,3};
    ll maxmin = minSubArrayLen( 7 , arr);
    cout << maxmin;
};
