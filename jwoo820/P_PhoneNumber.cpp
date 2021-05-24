//
//  main.cpp
//  Programmers_PhoneNumber
//
//  Created by Park Jungwoo on 2021/05/24.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    int len = phone_book.size();
    sort(phone_book.begin(), phone_book.end());
    
    for(int i=0; i< len-1; i++){
        if(phone_book[i] == phone_book[i+1].substr(0, phone_book[i].size()))
            return false;
    }
    return answer;
}
void print(bool x)
{
    if (x) cout << "true"<<'\n';
    else cout << "false"<<'\n';
}
int main(int argc, const char * argv[]) {
    // insert code here...
    vector<string> book1;
    vector<string> book2;
    vector<string> book3;
    book1.push_back("119");
    book1.push_back("976742223");
    book1.push_back("11955224421");
    book2.push_back("123");
    book2.push_back("456");
    book2.push_back("789");
    book3.push_back("12");
    book3.push_back("123");
    book3.push_back("1235");
    book3.push_back("567");
    book3.push_back("88");
    print(solution(book1));
    print(solution(book2));
    print(solution(book3));
    return 0;
}
