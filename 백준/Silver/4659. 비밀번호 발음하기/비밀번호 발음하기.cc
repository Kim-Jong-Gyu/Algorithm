#include <bits/stdc++.h>
using namespace std;

const char vow[] = {'a', 'e', 'i', 'o', 'u'};
string s;
int checkCon[24];

int checkVow(char c)
{
    for (int i = 0; i < 5; i++)
    {
        if (vow[i] == c)
            return 2;
    }
    return 1;
}

int checkT(char s1, char s2)
{
    if (s1 == s2)
    {
        if (s1 == 'e' && s2 == 'e')
        {
            return 1;
        }
        if (s1 == 'o' && s2 == 'o')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 1;
}

int main()
{
    while(true)
    {
        cin >> s;

        if (s.compare("end") == 0)
        {
            exit(0);
        }

        int cnt = 0;
        int flag = 0;
        fill(&checkCon[0], &checkCon[0] + 24, 0);
        for (int i = 0; i < s.size(); i++)
        {
            checkCon[i] = checkVow(s[i]);
            if ((i + 1) < s.size())
            {
                if (checkT(s[i], s[i + 1]) == 0)
                {
                    cnt++;
                }
            }
        }
        for (int i = 0; i < s.size(); i++)
        {
            if (checkCon[i] == 2)
            {
                flag = 1;
            }
            if (i >= 2)
            {
                if (checkCon[i - 2] == checkCon[i - 1] && checkCon[i - 1] == checkCon[i])
                {
                    cnt++;
                }
            }
        }
        if (flag == 0 || cnt != 0)
        {
            cout << "<" << s << ">"
                 << " is not acceptable." << '\n';
        }
        else
        {
            cout << "<" << s << ">"
                 << " is acceptable." << '\n';
        }
    }
}