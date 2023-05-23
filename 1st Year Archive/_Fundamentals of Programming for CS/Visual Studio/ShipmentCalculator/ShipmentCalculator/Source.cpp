#include <iostream>

using namespace std;

int main()
{
	const int initialCost = 50;
	const float rateOne = 5.5;
	const float rateTwo = 4.0;
	const float rateThree = 2.5;

	int distance;
	int distTracker;
	float totalCost;

	cout << "Each shipment incurs a fixed cost of \x9C 50 and the price per mile is calculated according to the rules below:\n\nEach of the first 100 miles cost \x9C 5.50\nOver 100 miles and up to and including 500 miles: \x9C 4 per mile\nOver 500 miles: \x9C 2.5 per mile\n\n";
	cout << "Please enter distance to ship parcel over (in whole miles): ";
	cin >> distance;
	distTracker = distance;

	totalCost = 0;
	totalCost += initialCost;

	/*for (int i = 0; i < distance; i++)
	{
		if (distTracker <= 100)
		{
			totalCost += 5.5;
		}
		else if (distTracker > 100 && distTracker <= 500)
		{
			totalCost += 4;
		}
		else if (distTracker > 500)
		{
			totalCost += 2.5;
		}

		//cout << "\n" << totalCost << "\n";
		//cout << "\n" << distTracker;

		distTracker--;
	}*/

	const int distBracketOne = 100;
	const int DIST_BRACKET_TWO = 500;

	if (distance <= 0)
	{
		cout << "dummy";
	}
	else
	{
		if (distance <= distBracketOne)
		{
			totalCost += rateOne * distance;
		}
		else
		{
			if (distance <= DIST_BRACKET_TWO)
			{
				totalCost += rateOne * distBracketOne;
				totalCost += rateTwo * (distance - distBracketOne);
			}
			else
			{
				totalCost += rateOne * distBracketOne;
				totalCost += rateTwo * (DIST_BRACKET_TWO - distBracketOne);
				totalCost += rateThree * (distance - DIST_BRACKET_TWO);
			}
		}
	}

	cout << "\nTotal cost: \x9C" << totalCost << "\n\n\n";

	system("pause");
	return 0;
}