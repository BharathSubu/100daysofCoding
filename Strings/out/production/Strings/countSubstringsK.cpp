// https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/

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

// time limit passed
long long int atMostK(string &A, int K)
{
    long long int i = 0, res = 0;
    int count[26] = {0};
    for (long long int j = 0; j < A.size(); ++j)
    {
        if (!count[A[j] - 97]++)
            K--;
        while (K < 0)
        {
            if (!--count[A[i] - 97])
                K++;
            i++;
        }
        res += j - i + 1;
    }
    return res;
}

// time limit failed
long long int atmost(string s, int k)
{
    map<char, int> m;
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

long long int substrCount(string s, int k)
{
    return atMostK(s, k) - atMostK(s, k - 1);
}
int main()
{

    string s = "abaaca";
    cout << substrCount(s, 2);
}