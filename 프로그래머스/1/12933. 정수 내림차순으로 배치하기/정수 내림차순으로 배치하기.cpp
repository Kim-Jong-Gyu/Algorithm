#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<long long> v;
long long solution(long long n) {
    long long answer = 0;
    while(n > 0){
        v.push_back(n % 10);
        n /= 10;
    }
    sort(v.begin(), v.end(), greater<long long>());
    for(long long i = 0; i < v.size(); i++){
        if(v[i] == 0)
            continue;
        else
            answer += v[i] * (long long)pow(10, v.size() - 1 -i); 
    }
    return answer;
}