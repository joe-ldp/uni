#pragma once
#include "EasyGraphics.h"

class MyWindow : public EasyGraphics
{
public:
	MyWindow();
	~MyWindow();

protected:
	virtual void onDraw();
	virtual void onMouseMove(UINT nFlags, int x, int y);
	virtual void onChar(UINT nChar, UINT nRepCnt, UINT nFlags);
	virtual void onTimer(UINT nIDEvent);


private:
	void drawCircles();

	int noofpts;
	static int const MAX_PTS = 10000;
	int mx[MAX_PTS], my[MAX_PTS];

	int ex, ey, moveEle;

	DWORD lastTick;
};