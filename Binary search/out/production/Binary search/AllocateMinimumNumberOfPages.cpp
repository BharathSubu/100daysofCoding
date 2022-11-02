// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=allocate-minimum-number-of-pages

#include <bits/stdc++.h>
#include <vector>
using namespace std;

typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vl vector<ll>
#define vvi vector<vector<int>>

int allocation(int A[], int N, int M, int mid)
{
    int sum = 0;
    int partition = 1;
    FOR(i, 0, N)
    {

        if (A[i] > mid)
        {
            return M + 1;
        }
        if (sum + A[i] > mid)
        {
            partition++;
            sum = A[i];
        }
        else
        {

            sum += A[i];
        }
    }
    return partition;
}

int findPages(int A[], int N, int M)
{
    if (M == N)
        return A[N - 1];
    if (M > N)
        return -1;
    int start = A[0], end = 0;
    FOR(i, 0, N)
    {
        end += A[i];
    }
    int minmax = A[0];
    while (start <= end)
    {
        int mid = start + (end - start) / 2;
        // cout << mid << " " << allocation(A, N, M, mid);
        // nl;
        if (allocation(A, N, M, mid) <= M)
        {
            minmax = mid;
            end = mid - 1;
        }
        else if (allocation(A, N, M, mid) > M)
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return minmax;
}

int main()
{

    int arr[] = {11, 16, 19, 55, 60, 71, 76, 80, 88, 90, 90};
    ll minmax = findPages(arr, 11, 2);
    cout << minmax;
};
