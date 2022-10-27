// https://www.codechef.com/START62B/problems/PYTHAGORAS

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

vl arr = {-1,-1};

bool isPrime(int num , int fac){
    for (int i = 0; i * i <= num; ++i)
    {
        int b = num - i * i, a = sqrt(b);
        if (a * a == b)
        {
            ll shift = (fac / 2);
            arr[0] = i << shift;
            arr[1] = a << shift;
            return true;
        }
    }
    return false;
}

bool judgeSquareSum(int n)
{
for (int i = 2;
        i * i <= n; i++)
{
    int count = 0;
    if (n % i == 0)
    {
        
        while (n % i == 0)
        {
            count++;
            n /= i;
        }
 
        
        if (i % 4 == 3 && count % 2 != 0)
            return false;
    }
}
return n % 4 != 3;
}

void solve()
{
    int num;
    cin >> num;
     int fac = 0;
    while (num % 2 == 0)
    {
        fac++;
        num /= 2;
    }
    if (fac % 2 != 0)
    {
        fac--;
        num *= 2;
    }
    if(judgeSquareSum(num)) {
        isPrime( num ,  fac);
        cout<<arr[0]<<' '<<arr[1];
    }
    else
    cout<<"-1";nl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
        solve();
}