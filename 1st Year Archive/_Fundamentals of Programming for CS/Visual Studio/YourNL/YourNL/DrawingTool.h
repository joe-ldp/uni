#pragma once
#include "EasyGraphics.h"

class DrawingTool : public EasyGraphics
{
public:
	DrawingTool();
	~DrawingTool();

	virtual void onDraw();
	int colour;
	
	const int numBars = 63;
	double bars[63];
};