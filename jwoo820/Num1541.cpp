//
//  main.cpp
//  Num1541
//
//  Created by Park Jungwoo on 2021/05/10.
//

#include <iostream>
#include <string>
using namespace std;
int main(int argc, const char * argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;
    bool isMinus = false;
    int sum = 0;
    int tmp = 0;
    cin >> str;
    for (int i=0; i < str.length(); i++) {
        if (str[i] == '+' || str[i] == '-') {
            if(isMinus == true){
                sum -= tmp;
            }
            else{
                sum += tmp;
            }
            tmp = 0;
            if (str[i]=='-') isMinus = true;
        }
        else{
            tmp *= 10;
            tmp += str[i] - '0';
        }
    }
    // 마지막 숫자 처리
    if (isMinus) sum -= tmp;
    else sum += tmp;

    cout << sum;
}

// 덧셈끼리는 모두 묶음
// - 나오기 전까지 묶음
// 55-(50+40)-12
//
