#include <Windows.h>
#include <crtdbg.h>
#include "MyWindow.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE prevInstance, LPSTR lpCmdLine, int show)
{
#ifdef _DEBUG
	_onexit(_CrtDumpMemoryLeaks);
#endif

	MyWindow myWindow;
	myWindow.create(hInstance, 800, 600, 100, true);

	return 0;
}