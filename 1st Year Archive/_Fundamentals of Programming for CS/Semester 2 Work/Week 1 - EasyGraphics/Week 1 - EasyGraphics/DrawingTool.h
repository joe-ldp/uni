#pragma once
#include "EasyGraphics.h"

class DrawingTool : public EasyGraphics
{
	public:
	DrawingTool();
	~DrawingTool();

	virtual void onDraw();
	int colour, defaultTextColour;
	int mx, my;
	bool keyPressed;
	int press;
	virtual void onMouseMove(UINT nFlags, int x, int y);
	virtual void onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags);
};