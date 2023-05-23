#include <windows.h>
#include "DrawingTool.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdline, int  show)
{
	DrawingTool dt;
	dt.create(hInstance, 1570, 380, 100, true);

	return 0;
}