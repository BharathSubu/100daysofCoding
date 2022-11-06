#include <bits/stdc++.h>
using namespace std;

long long reversedBits(long long X)
{
    long long original = X;
    if (X > INT_MAX || X < INT_MIN)
        return original;
    long long rev = 0;
    int power = (int)(log2(X));
    int pow2 = power;

    while (X)
    {
        if (X & 1)
        {
            rev = ((1 << power) | rev);
        }
        X = X >> 1;
        power--;
    }

    long long shift = 31 - pow2;
    long long res = rev << shift;

    return res;
}

int main()
{
    cout << reversedBits(13);
}