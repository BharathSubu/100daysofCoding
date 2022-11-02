// https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>> 
int NthRoot(int n, int m)
{
    if(n==1) return m;
    ll start = 1 , end = sqrt( m);
    while (start<=end)
    {
        ll mid = start + (end-start)/2;
        ll ans = pow(mid,n);
        if(ans == m ) return mid;
        if(ans > m){
            end = mid -1;
        }
        else start = mid+1;
    }
    
    return -1;
}
int main()
{

    cout << NthRoot(7 ,78125);
}