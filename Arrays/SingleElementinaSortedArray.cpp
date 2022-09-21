// https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int singleNonDuplicate(vector<int> &nums)
{

    int n = nums.size() ;
    int start = 0, end = n - 1;
    int single = -1;
    if (n % 2 == 0)
        return single;
    if(n == 1) return nums[0];
    if(nums[n-2] != nums[n-1]) return nums[n-1];
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        cout<<start<<" "<<mid<<" "<<end;nl;
        if (nums[mid] < nums[mid + 1])
        {
            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid])
            {
                return mid;
            }
            if (mid == 0)
                return mid;
        }
        if ( (mid - start + 1) % 2 == 0 && nums[mid] != nums[mid+1])
        {
              
                start = mid + 1;
        }
        else
        {
            
                end = mid - 1;
        }
    }
    return -1;
}

int main()
{

    vi arr = {1, 1,2, 2, 3, 3, 4, 4,  8};
    int idx = singleNonDuplicate(arr);
    cout << idx;
}