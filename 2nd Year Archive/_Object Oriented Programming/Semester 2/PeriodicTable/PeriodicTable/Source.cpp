#include <Windows.h>
#include <crtdbg.h>
#include "PeriodicTable.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int show)
{
#ifdef _DEBUG
	_onexit(_CrtDumpMemoryLeaks);
#endif

	PeriodicTable window;
	window.create(hInstance, 600, 550, 50, true);

	return 0;
}