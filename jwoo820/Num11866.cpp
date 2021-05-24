//
//  main.cpp
//  Num11866
//
//  Created by Park Jungwoo on 2021/05/17.
//  원형 큐

#include <iostream>
#include <queue>
using namespace std;
int main(int argc, const char * argv[]) {
    // insert code here...
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    int n, k;
    cin >> n >> k;
    queue<int> q;
    for (int i=1; i<=n; i++) {
        q.push(i);
    }
    cout<<'<';
    while (!q.empty()) {
        for (int i=1; i<k; i++) {
            q.push(q.front());
            q.pop();
        }
        cout<<q.front();
        q.pop();
        if (!q.empty()) {
            cout<<", ";
        }
    }
    cout<<'>'<<'\n';
    return 0;
}
//N = 7
//K = 3
//
//1,2,3,4,5,6,7
//3,4,5,6,7,1,2 -> 3
//4,5,6,7,1,2
//6,7,1,2,4,5 -> 6
//7,1,2,4,5
//2,4,5,7,1 -> 2
//4,5,7,1
//7,1,4,5 -> 7
//1,4,5
//5,1,4 -> 5
//1,4
//1,4 -> 1
//4 -> 4
//=>3,6,2,7,5,1,4
