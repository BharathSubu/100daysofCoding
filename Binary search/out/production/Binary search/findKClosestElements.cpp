// https://leetcode.com/problems/find-k-closest-elements

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

vector<int> findClosestElements(vector<int> &arr, int k, int x)
{
    int start = 0, end = arr.size() - 1;
    int n = arr.size();
    vi res;
    if(x < arr[0] ) {
        res = vector<int>(arr.begin(), arr.begin() + k);
        return res;
    }
    if(x > arr[end] ) {
        res = vector<int>(arr.end() - k, arr.end());
        return res;
    }
    
    int pos = -1;
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        if (arr[mid] == x)
        {
            pos = mid;
            break;
        }
        if (arr[mid] > x)
            end = mid - 1;
        else
            start = mid + 1;
    }
    if(pos == -1){
        int si = abs(x-arr[start]);
        int ei = abs(x-arr[end]);
        pos = si<ei?start:end;
    }
    int i = 1 , j = 1 ;
    res.push_back(arr[pos]);
    int inserted = 1;
    while(inserted != k ){
        
        int iIndex = (pos - i)!= -1 ? abs(x - arr[pos - i]) : INT_MAX;
        int jIndex = (pos + j)!= n ? abs(x - arr[pos + j]) : INT_MAX;
        if(iIndex == jIndex){
            int add = arr[pos-i] < arr[pos + j] ? arr[pos-i] : arr[pos + j];
            res.push_back(add);
            arr[pos-i] < arr[pos + j] ? i++ : j++;
        }
       else if(iIndex < jIndex){
            res.push_back(arr[pos - i]);
            i++;
        }
        else{
            res.push_back(arr[pos + j]);
            j++;
        }
        inserted++;
    }
    return res;
}

int main()
{

    vi arr = {0,0,1,2,3,3,4,7,7,8};
    int k = 3, x = 5;
    vi res = findClosestElements(arr, k, x);
    FOR(i, 0, res.size())
        cout << res[i] << " ";
}