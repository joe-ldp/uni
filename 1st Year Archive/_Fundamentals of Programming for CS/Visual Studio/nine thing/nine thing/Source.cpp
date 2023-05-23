#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
	int dim1, dim2;

	cout << "Please input first number: ";
	cin >> dim1;
	cout << "\nPlease input second number: ";
	cin >> dim2;
	
	vector<int> singleLine(dim2, 0);
	vector<vector<int> > theNumbers(dim2, singleLine);

	int content = dim1;

	for (int x = 0; x < dim2; x++)
	{
		for (int y = 0; y < dim2; y++)
		{
			theNumbers[x][y] = content - ((y+x)*2);
		}
	}

	for (int x = 0; x < dim2; x++)
	{
		for (int y = 0; y < dim2; y++)
		{
			cout << theNumbers[x][y] << " ";
		}
		cout << "\n";
	}

	cout << "\n\n";
	return 0;
}