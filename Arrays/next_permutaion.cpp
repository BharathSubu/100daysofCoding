// next_permutation : find next lexicographically greater permutation
// Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

// Example 1 :

// Input format: Arr[] = {1,3,2}

// Output: Arr[] = {2,1,3}

// Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
// Example 2:

// Input format: Arr[] = {3,2,1}

// Output: Arr[] = {1,2,3}

// Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>

void solve()
{
    int n;
    cin >> n;
    vi nums(n);
    FOR(i, 0, n)
        cin >> nums[i];
    int flag = 0;
    int i1, i2;
    FORD(i, n - 2, 0)
    {
        if (nums[i] < nums[i + 1])
        {
            i1 = i;
            flag = 1;
            break;
        }
    }
    if (flag)
    {
        FORD(i, n - 1, 0)
        {
            if (nums[i1] < nums[i])
            {
                i2 = i;
                break;
            }
        }

        nl;
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
        reverse(nums.begin() + i1 + 1, nums.end());
    }
    else
    {
        reverse(nums.begin(), nums.end());
    }
    FOR(i, 0, n)
        cout << nums[i] << " ";
}

int main()
{
    solve();
}