#include "DrawingTool.h"
#include <chrono>
#include <time.h>

using namespace std;

DrawingTool::DrawingTool()
{
	colour = WHITE;
	defaultTextColour = BLUE;
	setImmediateDrawMode(false);

	generateRandomPay();
}

DrawingTool::~DrawingTool()
{
	
}

void DrawingTool::onDraw()
{
	clearScreen(colour);
	setBackColour(GREY);
	setPenColour(BLACK, 5);
	drawRectangle(0, 0, getWidth(), getHeight(), true);

	setFont(25, L"Tahoma");
	drawText("FIGURE OUT THE CORRECT CHANGE", 200, 30);
	
	drawAmounts();
	
	userPurchaseString = "£" + to_string(userPurchase);
	userPurchaseString.resize(6);
	drawText(userPurchaseString.c_str(), 50, 100);

	userPayString = "£" + to_string(userPay);
	userPayString.resize(6);
	drawText(userPayString.c_str(), 50, 200);

	changeDueString = "£" + to_string(changeDue);


	EasyGraphics::onDraw();
}

void DrawingTool::drawAmounts()
{
	setPenColour(BLACK, 2);
	setBackColour(DARK_GREY);

	setFont(25, L"Tahoma");
	drawRectangle(195, 100, 50, 50, true);
	drawText("1p", 200, 100);

	drawRectangle(295, 100, 50, 50, true);
	drawText("2p", 300, 100);

	drawRectangle(395, 100, 50, 50, true);
	drawText("5p", 400, 100);

	setFont(20, L"Tahoma");
	drawRectangle(495, 100, 50, 50, true);
	drawText("10p", 497, 105);

	drawRectangle(595, 100, 50, 50, true);
	drawText("20p", 597, 105);

	drawRectangle(695, 100, 50, 50, true);
	drawText("50p", 697, 105);

	setFont(25, L"Tahoma");
	drawRectangle(245, 200, 50, 50, true);
	drawText("£1", 250, 200);

	drawRectangle(345, 200, 50, 50, true);
	drawText("£2", 350, 200);

	drawRectangle(445, 200, 50, 50, true);
	drawText("£5", 450, 200);

	setFont(20, L"Tahoma");
	drawRectangle(545, 200, 50, 50, true);
	drawText("£10", 547, 205);

	drawRectangle(645, 200, 50, 50, true);
	drawText("£20", 647, 205);
}

void DrawingTool::generateRandomPay()
{
	srand((int)time(NULL));

	int pounds = (rand() % 30) + 5;
	double pennies = (double)rand();
	pennies /= 10000;

	userPurchase = pounds + pennies;
	userPurchase = roundf(userPurchase * 100) / 100;


	userPay = ceil(userPurchase);
	int mod;
	if (userPay <= 20)
	{
		mod = fmod(userPay, 5);
		userPay = userPay - mod + 5;
	}
	else
	{
		mod = fmod(userPay, 10);
		userPay = userPay - mod + 10;
	}

	changeDue = userPay - userPurchase;
	remainingDue = changeDue;
}

int DrawingTool::checkForChangeClicks(int mx, int my)
{
	int denomNum(0);
	if (my >= 100 && my <= 150)
	{
		if (mx >= 195 && mx <= 195 + 50) // 1p
		{
			denomNum = 0;
			drawText("it 1p", 195, 100);
		}
		if (mx >= 295 && mx <= 295 + 50) // 2p
		{
			denomNum = 1;
			drawText("it 2p", 295, 100);
		}
		if (mx >= 395 && mx <= 395 + 50) // 5p
		{
			denomNum = 2;
		}
		if (mx >= 495 && mx <= 495 + 50) // 10p
		{
			denomNum = 3;
		}
		if (mx >= 595 && mx <= 595 + 50) // 20p
		{
			denomNum = 4;
		}
		if (mx >= 695 && mx <= 695 + 50) // 50p
		{
			denomNum = 5;
		}
	}
	if (my >= 200 && my <= 250)
	{
		if (mx >= 245 && mx <= 245 + 50) // £1
		{
			denomNum = 6;
		}
		if (mx >= 345 && mx <= 345 + 50) // £2
		{
			denomNum = 7;
		}
		if (mx >= 445 && mx <= 445 + 50) // £5
		{
			denomNum = 8;
		}
		if (mx >= 545 && mx <= 545 + 50) // £10
		{
			denomNum = 9;
		}
		if (mx >= 645 && mx <= 645 + 50) // £20
		{
			denomNum = 10;
		}
	}

	return denomNum;
}

void DrawingTool::onMouseMove(UINT nFlags, int x, int y)
{
	mx = x;
	my = y;
	onDraw();
}

void DrawingTool::onLButtonDown(UINT nFlags, int x, int y)
{
	my = x;
	my = y;
	Coords c = Coords(mx, my);

	int denomNum = checkForChangeClicks(mx, my);
	denominations[denomNum][1] += 1;

	onDraw();
}

void DrawingTool::onRButtonDown(UINT nFlags, int x, int y)
{
	my = x;
	my = y;
	Coords c = Coords(mx, my);

	int denomNum = checkForChangeClicks(mx, my);
	denominations[denomNum][1] -= 1;

	onDraw();
}