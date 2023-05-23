#include "MyWindow.h"

MyWindow::MyWindow() : noofpts(0), ex(0), ey(0), moveEle(101), lastTick(0)
{
	setImmediateDrawMode(false);
}

MyWindow::~MyWindow()
{

}

void MyWindow::onDraw()
{
	clearScreen(RED);
	setBackColour(DARK_GREEN);

	drawCircles();

	const int eleHeight = 616;
	const int eleWidth = 820;
	const float eleAspect = eleHeight / (float)eleWidth;

	//drawBitmap(L"elephant.bmp", 0, 0, eleWidth, eleHeight, 0x00FF0000);

	int width = 200;
	int height = width * eleAspect;


	drawBitmap(L"elephant.bmp", ex, ey, width, height, 0x00FF0000);

	/*
		DWORD:
		R: 0 = 0x00
		G: 0 = 0x00
		B: 255 = 0xFF
	*/

	EasyGraphics::onDraw();
}

void MyWindow::onMouseMove(UINT nFlags, int x, int y)
{
	if ((nFlags & MK_CONTROL) == MK_CONTROL)
	{
		mx[noofpts] = x;
		my[noofpts++] = y;
		
		onDraw();
	}
}

void MyWindow::onChar(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	if (nChar == 'r' || nChar == 'R')
	{
		noofpts = 0;
		onDraw();
	}
	else if (nChar == 'a' || nChar == 'A')
	{
		moveEle = 101;
		moveEle = SetTimer(getHWND(), moveEle, 30, NULL);
		lastTick = GetTickCount();
	}
}

void MyWindow::drawCircles()
{
	for (int i = 0; i < noofpts; i++)
	{
		drawCircle(mx[i], my[i], 10, true);
	}
}

void MyWindow::onTimer(UINT nIDEvent)
{
	if (nIDEvent == moveEle)
	{
		
		DWORD now = GetTickCount();
		DWORD deltaTime = now - lastTick;

		ex += (100 * deltaTime) / 1000;
		ey += (100 * deltaTime) / 1000;

		lastTick = now;
		onDraw();

	}
}