// https://leetcode.com/problems/count-array-pairs-divisible-by-k/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

long long countPairs(vector<int> &nums, int k)
{
    unordered_map<ll,ll> map;
    ll  count = 0;
    FOR(i,0,nums.size()){
        int num = __gcd(nums[i] , k);
        for(auto &[gcd,times] : map){
           if((num * gcd) % k == 0){
              count+=times;
           }
        }
        map[num]++;
    }
    return count;
}
int main()
{
    vi nums = {1,2,3,4,5};
    int total;
    total = countPairs(nums, 2);
    cout << total;
}