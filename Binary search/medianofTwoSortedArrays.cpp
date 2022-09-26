// https://leetcode.com/problems/median-of-two-sorted-arrays/

#include <bits/stdc++.h>
#include <vector>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

// double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
// {
//     int n = nums1.size(), m = nums2.size();
//     int totaln = m + n;
//     int start1 = 0, end1 = n - 1, start2 = 0, end2 = m - 1;
//     int num = -1;
//     while (start1 <= end1 && start2 <= end2)
//     {
//         int mid1 = start1 + (end1 - start1) / 2;
//         int mid2 = start2 + (end2 - start2) / 2;
//         int elementsbehind = n - mid1 + m - mid2 - 2;
//         if (elementsbehind == totaln / 2)
//         {
//             int l1 = mid1 < 0 ? INT_MIN : nums1[mid1];
//             int l2 = mid2 < 0 ? INT_MIN : nums2[mid2];
//             int r1 = mid1 + 1 >= n ? INT_MAX : nums1[mid1 + 1];
//             int r2 = mid1 + 1 >= m ? INT_MAX : nums2[mid2 + 1];
//             if (l1 > r2)
//             {
//                 end1 = mid1 - 1;
//                 start2 = mid2 + 1;
//             }
//             else if (l2 > r1)
//             {
//                 end2 = mid2 - 1;
//                 start1 = mid1 + 1;
//             }
//             else
//             {
//                 double res = 0;
//                 if (totaln % 2 == 0)
//                 {
//                     cout << nums1[mid1] << " " << nums2[mid2] << " " << nums1[mid1 + 1] << " " << nums2[mid2 + 1];
//                     nl;
//                     if (mid1 + 1 < n && mid2 + 1 < m)
//                         res = (float)(max(nums1[mid1], nums2[mid2]) + min(nums1[mid1 + 1], nums2[mid2 + 1])) / 2;
//                     else if (mid1 + 1 < n)
//                         res = (float)(max(nums1[mid1], nums2[mid2]) + nums1[mid1 + 1]) / 2;
//                     else
//                         res = (float)(max(nums1[mid1], nums2[mid2]) + nums2[mid2 + 1]) / 2;
//                     return res;
//                 }
//                 else
//                 {
//                     cout << max(nums1[mid1], nums2[mid2]);
//                     nl;
//                     res = (float)max(nums1[mid1], nums2[mid2]);
//                     return res;
//                 }
//             }
//         }
//         else if (elementsbehind < totaln / 2)
//         {
//             if (nums1[mid1] < nums2[mid2])
//             {
//                 start1 = mid1 + 1;
//             }
//             else
//             {
//                 start2 = mid2 + 1;
//             }
//         }
//         else
//         {
//             if (nums1[mid1] > nums2[mid2])
//             {
//                 end1 = mid1 - 1;
//             }
//             else
//             {
//                 end2 = mid2 - 1;
//             }
//         }
//         cout << "loop";
//     }
//     return double(nums1[0] + nums2[0]) / 2;
// }

double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
{
    if (nums2.size() < nums1.size())
        return findMedianSortedArrays(nums2, nums1);
    int n1 = nums1.size();
    int n2 = nums2.size();
    int low = 0, high = n1;
    while (low <= high)
    {
        int cut1 = (low + high) >> 1;
        int cut2 = (n1 + n2 + 1) / 2 - cut1;
        int left1 = cut1 == 0 ? INT_MIN : nums1[cut1 - 1];
        int left2 = cut2 == 0 ? INT_MIN : nums2[cut2 - 1];
        int right1 = cut1 == n1 ? INT_MAX : nums1[cut1];
        int right2 = cut2 == n2 ? INT_MAX : nums2[cut2];
        if (left1 <= right2 && left2 <= right1)
        {
            if ((n1 + n2) % 2 == 0)
               { return (max(left1, left2) + min(right1, right2)) / 2.0;}
            else
               { return max(left1, left2);}
        }
        else if (left1 > right2)
        {
            high = cut1 - 1;
        }
        else
        {
            low = cut1 + 1;
        }
    }
    return 0.0;
}
int main()
{
    vi nums1 = {11};
    vi nums2 = {1, 2, 3, 4, 5, 6, 7};
    double med = findMedianSortedArrays(nums1, nums2);
    cout << med;
}