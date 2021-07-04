#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for (int i = 0; i < commands.size(); i++) {

        vector<int> buff;
        int num_i = commands[i][0] - 1;
        int num_j = commands[i][1] - 1;
        int num_k = commands[i][2];

        for (int j = num_i; j <= num_j; j++) {
            buff.push_back(array[j]);
        }

        sort(buff.begin(), buff.end());

        answer.push_back(buff[num_k - 1]);


    }

    return answer;
}