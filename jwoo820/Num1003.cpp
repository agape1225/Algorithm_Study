//
//  main.cpp
//  Num1003
//
//  Created by Park Jungwoo on 2021/05/28.
//

#include <iostream>
using namespace std;
int dp[41] = {0,1};

int main(int argc, const char * argv[]) {
    // insert code here...
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    int t, n;
    cin >> t;
    // dp 사전 계산 ->
    for (int i=2; i<=40; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    for (int i=0; i<t; i++) {
        cin >> n;
        if (n == 0) cout << "1 0" << '\n';
        else cout << dp[n-1] << ' ' << dp[n] << '\n';
    }
    return 0;
}
// n -> 0 1
// --------
// 0 -> 1 0
// 1 -> 0 1
// 2 -> 1 1
// 3 -> 1 2
// 4 -> 2 3
// 5 -> 3 5
// 0 일때만 1, 0 출력
// 나머지 피보나치로 됨
