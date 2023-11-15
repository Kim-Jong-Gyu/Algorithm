#include <string>
#include <vector>

using namespace std;
int sum, tmp;
bool solution(int x) {
    tmp = x;
    while(tmp > 0){
        sum +=tmp % 10;
        tmp /= 10;
    }
    if(x % sum == 0)
        return true;
    return false;
}
