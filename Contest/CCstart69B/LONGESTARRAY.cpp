// https://www.codechef.com/START69B/problems/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define vvi vector<vector<int>>

int subarrayBitwiseORs(vector<int> &arr)
{

    int n = arr.size();

    set<int> st;
    map<pair<int, int>, int> map;

    for (int i = 0; i < arr.size(); i++)
    {
        int curr_OR = arr[i];
        int prev_OR = 0;
        int j = i - 1;
        st.insert(curr_OR);
        pair<int, int> p1;
        p1.first = i;
        p1.second = j;
        map[p1] = curr_OR;
        while (j >= 0 && curr_OR != prev_OR)
        {

            curr_OR = curr_OR | arr[j];
            prev_OR = prev_OR | arr[j];
            st.insert(curr_OR);
            p1.second = j;
            map[p1] = curr_OR;
            j--;
        }
        while (j >= 0)
        {
            p1.second = j;
            map[p1] = curr_OR;
            j--;
        }
    }
    for (auto i : map)
        cout << i.first.first << " " << i.first.second << "   " << i.second
             << endl;
    return (int)st.size();
}

void solve()
{
    int n;
    cin >> n;
    vi arr(n);
    FOR(i, 0, n)
    {
        int num;
        cin >> num;
        arr.push_back(num);
    }

    subarrayBitwiseORs(arr);
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}