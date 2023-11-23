#include<bits/stdc++.h>
using namespace std;

int t[104];
int a, b, c, ret;
int startTime, endTime;
int main(){
    cin >> a >> b >> c;
    for(int i = 0; i < 3; i++){
        cin >> startTime >> endTime;
        for(int j = startTime; j < endTime; j++){
            t[j]++;
        }
    }
    for(int i : t){
        if(i == 1)
            ret += i * a;
        if(i == 2)
            ret += i * b;
        if (i == 3)
            ret += i * c;
    }
    cout << ret << '\n';
}