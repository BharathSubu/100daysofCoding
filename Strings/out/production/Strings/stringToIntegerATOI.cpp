// https://leetcode.com/problems/string-to-integer-atoi/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define nl cout << "\n";
#define vi vector<int>
#define pb push_back
#define vvi vector<vector<int>>

int myAtoi(string s)
{
       int minus = 0;
    string res;
    int start = -1,end = -1;
    int k =0;
    while(k<s.size()){
            if(s[k]==' ' )k++;   
            else break;       
    }
    FOR(i, k, s.size())
    {
        if (s[i] == '-' && s[i + 1] >= '0' && s[i + 1] <= '9')
        {
            minus = 1;
        }
        else if (s[i] == '+' && s[i + 1] >= '0' && s[i + 1] <= '9')
        {
            // minus = 1;
        }
        else if (s[i] == '0' && start==-1 && (s[i+1] >= '0' && s[i+1] <= '9') )
        {
            
        }
        else if (s[i] == '0' && start==-1 && !(s[i+1] >= '0' && s[i+1] <= '9') )
        {
            return 0;
        }
        else if (s[i] >= '1' && s[i] <= '9' && start==-1)
        {
            start = i;
            end = i;

        }
        else if (s[i] >= '0' && s[i] <= '9' && start!=-1)
        {
            end = i;
        }
        else
        {
            end = i-1;
            break;
        }
    }
    if(start != -1 )
    res = s.substr(start,end - start + 1);
    else return 0;
    long long num = 0;
    FOR(i,0,res.size()){
        int cnum = res[i] - '0';
        if(num > INT_MAX && !minus) return INT_MAX;
        if(num > INT_MAX && minus) return INT_MIN;
        num+= cnum * pow(10,res.size()-i-1);
        if(num > INT_MAX && !minus) return INT_MAX;
        if(num > INT_MAX && minus) return INT_MIN;
        cout<<num<<" ";nl;
    }
    if(minus) return 0 - num;
    return num;
}
int main()
{

    string s = "2147483647";
    cout << myAtoi(s);
}