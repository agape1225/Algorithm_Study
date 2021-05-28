#include <string>
#include <vector>
#include <algorithm>

using namespace std;
//using namespace vector;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";

    vector<string> ::iterator it;

    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());

    for (int i = 0; i < completion.size(); i++) {

        if (participant[i] != completion[i])
            return participant[i];

        /*it = lower_bound(completion.begin(), completion.end(), participant[i]);

        if (participant[i] == *it) {
            *it = "";
            completion.erase(it);

        }
        else {
            answer = participant[i];
            break;
        }*/
        

    }

    return participant[participant.size()];
}