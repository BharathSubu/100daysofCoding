/*
Find quadtruples in a permutated array such that i<j<k<l and arr[i]<arr[k]<arr[j]<arr[l]
*/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>
#define pb push_back

int countQuadTruples(vector<int> &arr, int n)
{
    vvi jk;
    vvi il;
    if (n < 4)
        return 0;
    FOR(j, 1, n - 1)
    {
        FOR(k, j + 1, n - 1)
        {
            if (arr[k] < arr[j])
            {

                vi pair(2);
                pair[0] = j;
                pair[1] = k;
                jk.pb(pair);
            }
        }
    }
    FOR(i, 0, n - 3)
    {
        FOR(l, i + 3, n)
        {
            if (arr[i] < arr[l])
            {
                vi pair(2);
                pair[0] = i;
                pair[1] = l;
                il.pb(pair);
            }
        }
    }
    int count = 0;
    FOR(i, 0, il.size())
    {
        FOR(j, 0, jk.size())
        {
            if (arr[il[i][0]] < arr[jk[j][1]] && arr[jk[j][0]] < arr[il[i][1]])
            {
                cout << il[i][0] + 1 << jk[j][0] + 1 << jk[j][1] + 1 << il[i][1] + 1;
                count++;
                nl;
            }
        }
    }

    return count;
}
int main()
{
    vi arr = {2, 1, 5, 4, 6, 3};
    int n = arr.size();
    cout << countQuadTruples(arr, n);
}