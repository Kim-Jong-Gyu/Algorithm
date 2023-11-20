#include<bits/stdc++.h>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    int j;
    for(int i = 0 ; i < 10; i++){
        auto it = find(numbers.begin(), numbers.end(), i);
        if(it == numbers.end())
            answer+= i;
    }
    return answer;
}