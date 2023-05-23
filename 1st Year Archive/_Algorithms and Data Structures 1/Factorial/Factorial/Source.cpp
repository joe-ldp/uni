#include <iostream>
#include <string>

using namespace std;

int factorial(int number);

int main()
{
	int input;
	while (true)
	{
		cin >> input;
		cout << "The factorial of " << input << " is " << factorial(input) << "\n";
	}

	return 0;
}

int factorial(int number)
{
	if (number > 0)
	{
		unsigned long result(1);
		for (unsigned long i = 1; i <= number; i++)
		{
			result *= i;
		}
		return result;
	}
	else if (number == 0)
	{
		return 1;
	}
	else if (number < 0)
	{
		return -1;
	}
}