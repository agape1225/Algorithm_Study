#include <iostream>
#include <sstream>

using namespace std;

int main(void) {
	string input;
	int buff;

	int sum = 0;
	int min = 0;
	bool dir = false;

	cin >> input;
	stringstream ss(input);

	while (ss >> buff) {

		if (buff > 0) {
			if (dir) {
				min += buff;
			}
			else {
				sum += buff;
			}
			
		}
		else {
			if (dir) {
				sum -= min;
				min = -1 * buff;
			
			}
			else {
				dir = !dir;
				min -= buff;
			}
			
		}

	}

	sum -= min;
		

	cout << sum;

	return 0;
}