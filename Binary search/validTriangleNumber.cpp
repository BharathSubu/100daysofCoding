//https://leetcode.com/problems/valid-triangle-number/?envType=study-plan&id=binary-search-ii

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
int triangleNumber(vector<int>& nums) {
      sort(nums.begin() , nums.end());
      int count = 0;
      FOR(i,0,nums.size()-2){
        FOR(j,i+1,nums.size()-1){
            int start = j+1 , end = nums.size() - 1;
            while (start<=end)
            {
                int mid = start + (end -start)/2;
                if(nums[mid] < nums[i] + nums[j]){
                    // cout<< nums[i] <<" "<<nums[j]<<" "<<nums[mid];nl; 
                    count += mid - start + 1;
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            
        }
      }  
      return count;
}

int main()
{

    vi arr = {4,2,3,4};
    int idx = triangleNumber(arr);
    cout << idx;
}