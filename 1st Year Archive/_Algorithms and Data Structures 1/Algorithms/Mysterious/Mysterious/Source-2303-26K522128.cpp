#include <iostream>

using namespace std;

int mysterious(int number);

int main()
{
	int result;

	for (int i = 0; i < 20; i++)
	{
		result = mysterious(i);
		cout << "Result: " << result << "\n";
	}

	system("pause");
	return 0;
}

int mysterious(int number)
{
	int number1, number2, sum;
	bool status;

	status = true;

	if (number < 0) status = false;
	else if (number = 0) sum = 0;
	else if (number = 1) sum = 1;
	else
	{
		number2 = 0;
		number1 = 1;
		for (int i = 2; i <= number; i++)
		{
			sum = number1 + number2;
			number2 = number1;
			number1 = sum;
		}
	}

	return sum;
}