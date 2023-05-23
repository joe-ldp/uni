#include <windows.h>
#include "DrawingTool.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdline, int  show)
{
    DrawingTool dt;
    dt.create(hInstance, 695, 715, 100, true);

    return 0;
}