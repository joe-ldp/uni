#include <iostream>

//#pragma execution_character_set ("utf-16");

using namespace std;

int main()
{
	float billAmount;
	int numGuests;

	cout << "Tip and Cost Calculator\n----------------\n";

	cout << "\nPlease enter bill amount: \x9C";
	cin >> billAmount;

	cout << "\nPlease enter number of guests: ";
	cin >> numGuests;

	float tip = billAmount * 0.12;
	cout << "\nTip: \x9C" << tip;

	float total = billAmount + tip;
	cout << "\nTotal: \x9C" << total;

	cout << "\nPer person: \x9C" << total / numGuests << "\n\n\n";

	system("pause");
	return 0;
}