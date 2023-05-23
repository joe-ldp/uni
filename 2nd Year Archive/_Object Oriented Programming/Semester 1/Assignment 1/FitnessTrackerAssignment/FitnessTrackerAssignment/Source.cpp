#include <crtdbg.h>
#include <iostream>
#include "FitnessTracker.h"
#include "Activity.h"
#include "Run.h"
#include "Walk.h"

using namespace std;

int main()
{
#ifdef _DEBUG
	//  _CrtSetBreakAlloc(302);
	_onexit(_CrtDumpMemoryLeaks);
#endif

	Activity* as[2] = { new Walk(), new Run() };

	for (int i = 0; i < 2; i++)
	{
		as[i]->report();
	}

	cout << "\n\n\n";
	return 0;
}