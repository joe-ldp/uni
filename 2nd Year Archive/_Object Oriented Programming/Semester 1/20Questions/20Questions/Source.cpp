#include <crtdbg.h>
#include <iostream>
#include "TwentyQuestions.h"

using namespace std;

int main()
{
#ifdef _DEBUG
	//  _CrtSetBreakAlloc(302);
	_onexit(_CrtDumpMemoryLeaks);
#endif

	TwentyQuestions TQ;

	TQ.playGame();

	return 0;
}