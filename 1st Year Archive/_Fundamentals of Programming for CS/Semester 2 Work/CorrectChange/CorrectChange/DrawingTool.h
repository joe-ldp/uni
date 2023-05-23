#pragma once
#include "EasyGraphics.h"
#include "Region.h"

class DrawingTool : public EasyGraphics
{
public:
	DrawingTool();
	~DrawingTool();

	// Integral functions
	virtual void onMouseMove(UINT nFlags, int x, int y);
	virtual void onLButtonDown(UINT nFlags, int x, int y);
	virtual void onRButtonDown(UINT nFlags, int x, int y);
	
	// User functions
	virtual void onDraw();
	virtual void drawAmounts();
	virtual void generateRandomPay();
	virtual int checkForChangeClicks(int mx, int my);

	// Integral variables
	int colour, defaultTextColour;
	int mx, my;

	// User variables
	double userPurchase, userPay;
	std::string userPurchaseString, userPayString;

	double changeDue, remainingDue;
	std::string changeDueString, remainingDueString;

	double denominations[11][2] =
	{
		0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00,
		0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0    , 0    ,
	};
};