#include <bits/stdc++.h>
using namespace std;

int n;
string s;
vector<string> v;

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s;
        int cnt = 0;
        for(int j = 0; j < s.size(); j++){
            if(s[j] == '('){
                cnt++;
            }
            if(s[j] == ')'){
                cnt--;
            }
            if(cnt < 0){
                break;
            }
        }
        if(cnt != 0){
            v.push_back("NO");
        }
        else{
            v.push_back("YES");
        }
    }
    for(string it : v){
        cout << it << '\n';
    }
}