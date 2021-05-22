//
//  main.cpp
//  Num1654
//
//  Created by Park Jungwoo on 2021/05/17.
//  시간초과

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    int k, n;       // 랜선 : k, 기준 : n -> cm
    // 랜선의 길이 2^32-1 -> long long
    long long max = 0;
    int result = 0;
    cin >> k >> n;
    vector<int> vec(k);
    for (int i=0; i<k; i++) {
        cin >> vec[i];
        if (max < vec[i]) {
            max = vec[i];
        }
    }
    // 이분탐색 -> 왼쪽 오른쪽 비교 후 중간 값 결정
    long long left = 1; // 자르는 전선의 길이
    long long right = max;  // 입력받은 최대 전선의 길이
    while (left <= right) { // 조건을 만족할 때까지 탐색 -> 둘이 같을 때가 최대 길이
        long long temp = 0;
        long long mid = (left+right)/2;
        for (int i=0; i<k; i++) {
            // 전선의 갯수
            temp += vec[i]/mid;
        }
        if(temp < n) right = mid - 1;   // n보다 작으면 중간값 1cm 줄임
        else{
            if(result < mid) result = mid;  // n 만족
            left = mid +1;  // 길이를 더 짜름
        }
    }
    cout << result << '\n';
    return 0;
}

// 랜선을 모두 더해서 평균 길이 구함 -> 230
// 최대 길이 -> right
// 자르는 길이 -> left

//4 11
//802
//743
//457
//539
