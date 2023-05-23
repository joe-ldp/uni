#include "DrawingTool.h"
#include <chrono>
#include <time.h>
#include <random>

DrawingTool::DrawingTool()
{
	colour = BLACK;
	setImmediateDrawMode(false);
	srand((int)time(NULL));
}

DrawingTool::~DrawingTool()
{

}

void DrawingTool::onDraw()
{
	clearScreen(colour);
	setBackColour(WHITE);
	setPenColour(WHITE, 0);

	for (int i = 0; i < 63; i++)
	{
		bars[i] = 5 + (abs(sin(i)) * 50) + ((rand() % 20) * 10);
	}

	int x = 3;
	for (int i = 0; i < 63; i++)
	{
		drawRectangle(x, getHeight() - bars[i], 19, bars[i], true);
		x += 25;
	}

	EasyGraphics::onDraw();
	//onDraw();
}