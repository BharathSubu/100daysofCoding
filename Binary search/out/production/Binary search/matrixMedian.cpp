// https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int countsmallerele(vi row , int mid){
    int start = 0 , end = row.size() - 1;
    while(start<=end){
        int md =(start+end)>>1;
        if(row[md] <= mid){
        start= md +1;
        }
        else end = md-1;
    }
    return start;
}

int median(vector<vector<int>> &matrix, int r, int c)
{
    int start = 1 , end = 1e9;
    while(start<=end){
        int mid = (start+end) >> 1;
        int count = 0;
        FOR(i,0,r){
            count+= countsmallerele(matrix[i],mid);
        }
        if(count <= (r*c)/2 ) start = mid+1;
        else end = mid -1;
    }
    return start;
}

int main()
{
    int r = 3, c = 3;
    vvi m = {{1, 3, 6},
             {2, 6, 9},
             {3, 6, 9}};
    cout << median(m, r, c);
}