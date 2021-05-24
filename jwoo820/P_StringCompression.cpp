//
//  main.cpp
//  Programmers_String compression
//
//  Created by Park Jungwoo on 2021/05/22.
//

#include <iostream>
#include <string>
using namespace std;

int solution(string s)
{
    int answer = s.length();
    int len = answer;
    // 경우의 수 탐색 -> 문자열을 자를 단위
    for (int i=1; i<=s.length(); i++) {
        string result = "";
        string tmp = s.substr(0, i); // 처음 비교
        int cnt = 1;                // 압축 x
        // 자를 단위만큼 이동하여 비교
        for (int j = i; j <= len; j+=i) {
            // 현재 압축이 존재할 경우
            if (tmp == s.substr(j, i)) {
                cnt++;
            }
            // 현재 압축이 없을 경우
            else{
                // 지금까지 압축이 없었을 경우
                if (cnt == 1) {
                    result += tmp;
                }
                // 지금까지 압축이 있었을 경우
                else result += (to_string(cnt) + tmp);
                tmp = s.substr(j, i);
                cnt = 1;
            }
        }
        // 문자열 자르는 단위에 포함 안되는 문자열 추가
        result += s.substr((len/i) * i);
        answer = min(answer, (int)result.length());
    }
    // 문자 탐색
    return answer;
}

void print(string s, int answer) {
    int t = solution(s);
    if (answer == t)
        cout << "정답" << endl;
    else
        cout << "틀림" << endl;
}
int main(int argc, const char * argv[]) {
    // insert code here...
    print("a", 1);
    print("aaaaa", 2);
    print("aaaaaaaaaa", 3);
    print("aabbaccc", 7);
    print("ababcdcdababcdcd", 9);
    print("abcabcdede", 8);
    print("abcabcabcabcdededededede", 14);
    print("xababcdcdababcdcd", 17);
    return 0;
}
