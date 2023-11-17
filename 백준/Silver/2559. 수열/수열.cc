#include <bits/stdc++.h>
using namespace std;
int num;
int unit;
int arr[100001];
int ret[100001];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int max = INT_MIN;
    cin >> num >> unit;
    for(int i = 1; i <= num; i++){
        cin >> arr[i];
        ret[i] = ret[i - 1] + arr[i];
        if(i > unit){
            ret[i] -= arr[i - unit];    
        }
    }
    for(int i = unit; i <= num; i++){
        if(ret[i] > max){
            max = ret[i];
        }
    }
    cout << max << '\n';
    return 0;
}