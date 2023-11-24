#include <bits/stdc++.h>
using namespace std;

int k = 3;
int result = 0;
int n = 0;
void check(vector<int> b){
    int sum = accumulate(b.begin(), b.end(), 0);
    if(sum == 0)
        result++;
}

void combi(int start, vector<int> b, vector<int> number)
{
    if(b.size() == k)
        check(b);
    for(int i = start + 1; i < n; i++){
        b.push_back(number[i]);
        combi(i, b, number);
        b.pop_back();
    }
    return ;
}
int solution(vector<int> number) {
    int answer = 0;
    vector<int> v;
    n = number.size();
    combi(-1, v, number);
    return result;
}