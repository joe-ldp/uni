#include <iostream>
#include <string>

using namespace std;

int main()
{
	string name;
	cout << "Hello world\n";
	cout << "What is your name? ";

	cin >> name;
	if (name != "jeff") return 1;
	cout << "\nPleased to meet you " << name << "\n";
	cout << "OK, let's do some real code now...\n\n";

	system("pause");

	return 0;
}