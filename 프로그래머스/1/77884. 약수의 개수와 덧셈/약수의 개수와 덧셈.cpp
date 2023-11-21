#include <bits/stdc++.h>
using namespace std;

bool divisor(int num){
    long long a = sqrt(num);
    if(a * a == num)
        return false;
    return true;
}

int solution(int left, int right) {
    int answer = 0;
    for(int i = left; i <= right; i++){
        if(divisor(i)){
            answer += i;
        }
        else {
            answer -= i;
        }
    }
    return answer;
}