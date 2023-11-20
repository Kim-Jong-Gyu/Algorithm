#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer = arr;
    answer.erase(min_element(answer.begin(), answer.end()));
    if(answer.size() == 0)
        return vector<int>{-1};
    return answer;
}