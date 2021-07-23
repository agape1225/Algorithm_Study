#include <iostream>
#include <sstream>
#include <windows.h>

using namespace std;

void gotoxy(int x, int y)
{
	COORD Cur;
	Cur.X = x;
	Cur.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Cur);
}

void print_num(int size, int x, int y, char num) {
	
	if (num == '1') {
		
		//y++;

		for (int i = 0; i < size; i++) {
			gotoxy(x, y + i);
			cout << '|';
		}

		y += size + 1;
		
		for (int i = 0; i < size; i++) {
			gotoxy(x, y + i);
			cout << '|';
		}

	}
	if (num == '2') {

		gotoxy(x + 1 , y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {
			
			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);
		
		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x , y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
	if (num == '3') {

		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
	if (num == '4') {

		for (int i = 0; i < size; i++) {
			gotoxy(x, y + i);
			cout << '|';
		}

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i + 1);
			cout << '|';

		}

	}
	if (num == '5') {


		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x , y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';


	}
	if (num == '6') {


		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
	if (num == '7') {

		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {
			gotoxy(x + size + 1, y + i);
			cout << '|';
		}

		y += size + 1;

		for (int i = 0; i < size; i++) {
			gotoxy(x + size + 1, y + i);
			cout << '|';
		}

	}
	if (num == '8') {

		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
	if (num == '9') {

		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		gotoxy(x + 1, y + size);

		for (int i = 0; i < size; i++)
			cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
	if (num == '0') {

		gotoxy(x + 1, y - 1);
		for (int i = 0; i < size; i++)
			cout << '-';

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + i);
			cout << '|';

		}

		//gotoxy(x + 1, y + size);

		//for (int i = 0; i < size; i++)
		//	cout << '-';

		y++;

		for (int i = 0; i < size; i++) {

			gotoxy(x + size + 1, y + size + i);
			cout << '|';

		}

		for (int i = 0; i < size; i++) {

			gotoxy(x, y + size + i);
			cout << '|';

		}

		gotoxy(x + 1, y + (size * 2));

		for (int i = 0; i < size; i++)
			cout << '-';

	}
}

int main(void) {

	string input;
	stringstream ss;
	int size, start_x, start_y;
	char buff;

	start_x = 1;
	start_y = 1;

	/*gotoxy(start_x, 0);
	print_num(4, start_x, start_y, '2');*/
	

	cin >> size >> input;
	ss.str(input);

	while (ss >> buff) {

		gotoxy(start_x, start_y);

		print_num(size, start_x, start_y, buff);
		start_y = 1;

		if (buff == '1')
			start_x += 2;
		else
			start_x += size + 3;

	}

	//Sleep(5000);

	return 0;

}