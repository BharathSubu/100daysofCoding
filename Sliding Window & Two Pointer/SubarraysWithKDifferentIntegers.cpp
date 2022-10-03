// https://leetcode.com/problems/subarrays-with-k-different-integers/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vc vector<char>
#define pb push_back
#define vvi vector<vector<int>>



// time limit failed
long long int atmost(vi s, int k)
{
    map<int, int> m;
    int n = s.size();
    int j = 0;
    int count = 0;
    FOR(i, 0, n)
    {
        m[s[i]]++;
        while (m.size() > k)
        {
            auto it = m.find(s[j]);
            it->second--;
            if (it->second == 0)
                m.erase(it);
            j++;
        }
        count += (i - j + 1);
    }
    return count;
}

int subarraysWithKDistinct(vector<int> &nums, int k)
{
    return atmost(nums, k) - atmost(nums, k - 1);
}

int main()
{

    vi nums = {1, 2, 1, 2, 3};
    int k = 2;
    cout << subarraysWithKDistinct(nums, 2);
}