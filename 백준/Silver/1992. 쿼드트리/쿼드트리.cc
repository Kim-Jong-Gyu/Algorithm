#include<bits/stdc++.h>
using namespace std;

char mp[100][100];
int n;
string s;

string quard(int y, int x, int rng){
    if(rng == 1) return string(1, mp[y][x]);
    char b = mp[y][x];
    string ret = "";
    for(int i = y; i < y + rng; i++){
        for(int j = x; j < x + rng; j++){
            if(mp[i][j] != b){
                ret += '(';
                ret += quard(y, x, rng/2);
                ret += quard(y, x + rng/2, rng/2);
                ret += quard(y + rng/2, x, rng/2);
                ret += quard(y + rng/2, x + rng/2, rng/2);
                ret += ')';
                return ret;
            }
        }
    }
    return string(1,mp[y][x]);
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = 0; j < n; j++){
            mp[i][j] = s[j];
        }
    }
    cout << quard(0,0,n) << '\n';
}