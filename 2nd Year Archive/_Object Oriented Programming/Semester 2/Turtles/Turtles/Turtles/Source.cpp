#include <Windows.h>
#include <crtdbg.h>
#include "TurtleWindow.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int show)
{
#ifdef _DEBUG
	_onexit(_CrtDumpMemoryLeaks);
#endif

	TurtleWindow window;
	window.create(hInstance, 800, 600, 50, true);

	return 0;
}