#include <iostream>

using namespace std;

int main()
{
	int sum(0);
	const int ceil = 1000;

	for (int i = 0; i < ceil; i++)
	{
		if (i % 3 == 0) sum += i;
		else if (i % 5 == 0) sum += i;
	}

	cout << "Sum: " << sum << "\n\n";
	
	system("pause");
	return 0;
}