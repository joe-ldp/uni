#include <iostream>
#include <list>
#include "AppMetadata.h"
#include <iterator>
#include <algorithm>
#include <vector>

using namespace std;

void displayApp(const AppMetadata& app);

int main()
{
	list<AppMetadata> lapps;

	lapps.push_back(AppMetadata("BBC News", 1000, MyDate(1, 1, 2016), MyDate(30, 10, 2017)));
	lapps.push_back(AppMetadata("BBC Sport", 1000, MyDate(1, 1, 2016), MyDate(30, 10, 2017)));
	lapps.push_back(AppMetadata("Eurosport", 1000, MyDate(1, 1, 2016), MyDate(30, 10, 2017)));
	lapps.push_back(AppMetadata("YouTube", 1000, MyDate(1, 1, 2016), MyDate(30, 10, 2017)));

	list<AppMetadata>::const_iterator it(lapps.cbegin());
	while (it != lapps.cend())
	{
		cout << (it++)->getAppName() << "\n";
	}

	for_each(lapps.begin(), lapps.end(), displayApp);

	vector<AppMetadata> vapps;
	

	return 0;
}

void displayApp(const AppMetadata& app)
{
	cout << "App " << app.getAppName() << " was installed on " << app.getInstalled().getDay() << " and last accessed on " << app.getLastAccessed().getDay() << ". It takes up " << app.getDiskSpace() << "\n";
}