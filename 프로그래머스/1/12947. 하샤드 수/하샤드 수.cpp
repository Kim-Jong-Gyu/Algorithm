#include <string>
#include <vector>

using namespace std;
vector<int> v;
int sum, tmp;
bool solution(int x) {
    tmp = x;
    while(tmp > 0){
        v.push_back(tmp % 10);
        tmp /= 10;
    }
    for(int a : v){
       sum+= a; 
    }
    if(x % sum == 0)
        return true;
    return false;
}