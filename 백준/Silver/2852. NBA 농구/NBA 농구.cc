#include <bits/stdc++.h>
using namespace std;

#define prev jong

int n, tn;
string st;
int aT;
int bT;
int aS;
int bS;
string prev;

void printV(int result)
{
    string m = "00" + to_string(result/60);
    string s = "00" + to_string(result%60);
    cout << m.substr(m.size() - 2, 2) <<  ":" + s.substr(s.size() - 2, 2) << '\n';
}

int changeInt(string a){
    return atoi(a.substr(0, 2).c_str()) * 60 + atoi(a.substr(3, 2).c_str());
}

int go(int sumT, string nT){
    int retT = 0;
    retT = sumT + changeInt(nT) - changeInt(prev);
    return retT;
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> tn >> st;
        if(aS > bS){
            aT = go(aT, st);
        }
        if(aS < bS){
            bT = go(bT, st);
        }
        if(tn == 1) aS++;
        if(tn == 2) bS++;
        prev = st;
    }
    if(aS > bS){
        aT = go(aT, "48:00");
    }
    if(aS < bS){
        bT = go(bT, "48:00");
    }
    printV(aT);
    printV(bT);
}