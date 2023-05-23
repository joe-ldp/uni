#include <iostream>

using namespace std;

long int mysterious(long int number);

int main()
{
	long int h;
	for (int i = 0; i < 100; i++)
	{
		h = mysterious(i);
		cout << i << ": " << h << "\n";
	}

	system("pause");
	return 0;
}

long int mysterious(long int number)
{
	int i, number1, number2;
	long int result(0);
	bool status = true;

	if (number < 0) status = false;
	else if (number == 0) result = 0;
	else if (number == 1) result = 1;
	else
	{
		number2 = 0;
		number1 = 1;
		for (i = 2; i <= number; i++)
		{
			result = number1 + number2;
			number2 = number1;
			number1 = result;
		}
	}

	return result;
}