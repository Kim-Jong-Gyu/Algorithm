#include<bits/stdc++.h>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    int flag = 1;
    if(a > b)
        flag *= -1;
    for(int i = 0; i <= abs(a - b); i++){
        answer += a + i * flag ;
    }
    return answer;
}