#include <string>
#include <vector>
#include <cstdio>

using namespace std;

void getTarget(vector<int> numbers, int target, int index, int &ans) {
    //printf("%d\n", target);

    if (index == numbers.size() - 1) {
        if (target + numbers[index] == 0)
            ans++;
        if (target - numbers[index] == 0)
            ans++;
    }
    else {
        getTarget(numbers, target + numbers[index], index + 1, ans);
        getTarget(numbers, target - numbers[index], index + 1, ans);
    }
    
}

int solution(vector<int> numbers, int target) {

    int answer = 0;
    int ans = 0;

    getTarget(numbers, target, 0, ans);

    answer = ans;


    return answer;
}

int main(void) {

    vector<int> v;

    v.push_back(1);
    v.push_back(1);
    v.push_back(1);
    v.push_back(1);
    v.push_back(1);

    int ans = solution(v, 3);

    printf("%d", ans);

    return 0;


}