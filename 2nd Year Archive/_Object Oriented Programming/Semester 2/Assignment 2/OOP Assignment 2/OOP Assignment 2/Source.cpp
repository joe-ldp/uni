#include <windows.h>
#include "Breakout.h"

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdline, int  show)
{
    Breakout br;
    br.create(hInstance, 800, 600, 100, true);

    return 0;
}