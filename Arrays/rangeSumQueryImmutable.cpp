// https://leetcode.com/problems/range-sum-query-immutable/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

class NumArray
{
public:
    vector<int> presum;
    NumArray(vector<int> &nums)
    {
        presum.resize(nums.size());
        int prev = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            presum[i] = prev + nums[i];
            cout << presum[i] << " ";
            prev = presum[i];
        }
        cout << "\n";
    }

    int sumRange(int left, int right)
    {
        if (left == 0)
            return this->presum[right];

        return this->presum[right] - this->presum[left - 1];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
