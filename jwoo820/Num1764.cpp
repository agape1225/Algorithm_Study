//
//  main.cpp
//  Num1764
//
//  Created by Park Jungwoo on 2021/05/17.
//
// find 함수 사용하니깐 시간 초과함
// 이진탐색으로 해결
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    int cnt=0;
    cin >> n >> m;
    vector<string> vec_n(n);
    vector<string> vec_m(m);
    vector<string> result;
    for (int i=0; i<vec_n.size(); i++) {
        cin >> vec_n[i];
    }
    sort(vec_n.begin(), vec_n.end());
    for (int i=0; i<vec_m.size(); i++) {
        cin >> vec_m[i];
    }
    sort(vec_m.begin(), vec_m.end());
    for (int i=0; i<vec_m.size(); i++) {
        if (binary_search(vec_n.begin(), vec_n.end(), vec_m[i])) {
            cnt++;
            result.push_back(vec_m[i]);
        }
    }
    cout << cnt <<'\n';
    for (auto v : result) {
        cout << v << '\n';
    }
    return 0;
}
//3 4
//ohhenrie
//charlie
//baesangwook
//obama
//baesangwook
//ohhenrie
//clinton
