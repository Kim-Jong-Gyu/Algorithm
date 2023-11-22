#include <bits/stdc++.h>

using namespace std;

bool solution(string s) {
    for(int i = 0; i < s.size(); i++){
        if(s[i] > '9'){
            return false;
        }
    }
    if(s.size() != 4 && s.size() != 6)
        return false;
    return true;
}