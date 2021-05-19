#include <string>
#include <iostream>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int size = s.size();
    int loop = size / 2;
    int min = size;

    for (int i = 1; i <= loop; i++) {

        int count = 0;
        string result;
        string compare_str = s.substr(0, i);

        for (int j = 0; j < size; j += i) {

            string current_str = s.substr(j, i);
            cout << current_str << " " << j << ", " << i << " " << ", " << count <<  endl;
            cout << compare_str << " " << j << ", " << i << " " << ", " << count << endl;

            if (j + i  >=  size) {
                if (compare_str == current_str) {
                    count++;
                    result += to_string(count) + compare_str;
                }
                else {

                    if (count > 1)
                        result += to_string(count);

                    result += compare_str;
                    result += current_str;

                }
                break;
            }

            if (compare_str == current_str) {
                count++;
            }
            else {
                if (count > 1) {
                    cout << current_str << endl;
                    result += to_string(count) + compare_str;
                }
                else {
                    cout << current_str << endl;
                    result += compare_str;
                }
                count = 1;
                compare_str = current_str;
            }
        }
        cout << result << endl << endl;

        if (result.size() < min)
            min = result.size();
    }

    answer = min;
    return answer;
}

int main(void) {
    string s = "ccccccccccccccccc";

    int ans = solution(s);
    cout << ans << endl;

    return 0;
}