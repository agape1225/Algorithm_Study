//
//  main.cpp
//  Programmers_TargetNumber
//
//  Created by Park Jungwoo on 2021/05/22.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int answer = 0;
void dfs(vector<int> numbers, int target, int depth, int sum)
{
    if(depth == numbers.size()){
        if(sum == target){
            answer++;
        }
        return;
    }
    dfs(numbers, target, depth+1, sum+numbers[depth]);
    dfs(numbers, target, depth+1, sum-numbers[depth]);
}
int solution(vector<int> numbers, int target) {
    
    dfs(numbers, target, 0, 0);
    return answer;
}
int main(int argc, const char * argv[]) {
    // insert code here...
    int target;
    cin >> target;
    vector<int> numbers;
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    numbers.push_back(1);
    solution(numbers, target);
    cout << answer << '\n';
    return 0;
}
