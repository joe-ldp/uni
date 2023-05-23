#include <chrono>
#include "DrawingTool.h"
#include <time.h>

DrawingTool::DrawingTool()
{
	colour = WHITE;
	defaultTextColour = BLUE;
	setImmediateDrawMode(false);
}

DrawingTool::~DrawingTool()
{

}

void DrawingTool::onDraw()
{
	clearScreen(colour);
	setBackColour(GREY);

	setPenColour(GREEN, 3);
	int dummy = 0, prevX = 0, prevY = 0;
	for (int i = 0; i < 800; i++)
	{
		if (i % 1 == 0)
		{
			int x = i * mx / 5;
			int y = my + (sin(x) * 15);
			drawLine(prevX, prevY, x, y);
			prevX = x;
			prevY = y;
		}
	}
	
	setPenColour(GREY, 10);

	drawLine(100, 300, 400, 100);
	drawLine(400, 100, 700, 300);

	setPenColour(BLACK, 10);

	drawLine(100, 700, 700, 700);
	drawLine(100, 300, 700, 300);
	drawLine(100, 300, 100, 700);
	drawLine(700, 300, 700, 700);

	setPenColour(YELLOW, 5);
	setBackColour(YELLOW);

	drawCircle(0, 0, 100, true);

	drawCircle(mx, my, 10, true);

	setFont(25, L"Tahoma");
	setTextColour(BLUE);
	drawText("Hello World", 100, 100);
	
	EasyGraphics::onDraw();
}

void DrawingTool::onMouseMove(UINT nFlags, int x, int y)
{
	mx = x;
	my = y;
	onDraw();
}

void DrawingTool::onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	keyPressed = true;

	switch (nChar)
	{
		case 'R':
			colour = RED;
			onDraw();
			break;
		case 'B':
			colour = BLUE;
			onDraw();
			break;
		case VK_LEFT:
			colour = YELLOW;
			setTextColour(BLACK);
			press = nChar;
			onDraw();
			break;
		case VK_RIGHT:
			colour = RED;
			press = nChar;
			onDraw();
			break;
		case VK_UP:
			colour = RED;
			onDraw();
			press = nChar;
			break;
		case VK_DOWN:
			colour = RED;
			onDraw();
			press = nChar;
			break;
	}
}