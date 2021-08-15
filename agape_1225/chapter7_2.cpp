#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {

	vector<int> arr;
	int M, N;
	int buff;

	cin >> M;

	for (int i = 0; i < M; i++) {
		
		cin >> buff;
		arr.push_back(buff);

	}

	sort(arr.begin(), arr.end());

	cin >> N;

	for (int i = 0; i < N; i++) {

		cin >> buff;

		if (binary_search(arr.begin(), arr.end(), buff)) {
			cout << "yes" << ' ';
		}
		else
			cout << "no" << ' ';

	}

	return 0;

}