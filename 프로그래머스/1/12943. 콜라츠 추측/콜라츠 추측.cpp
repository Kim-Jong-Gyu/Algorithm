#include <string>
#include <vector>

using namespace std;
long long input;
int solution(int num) {
    input = num;
    for(int i = 0; i < 500; i++){
        if(input == 1)
            return i;
        else {
            if(input % 2 == 0){
                input /= 2;
            }
            else {
                input *= 3;
                input++;
            }
        }
    }
    return -1;
}