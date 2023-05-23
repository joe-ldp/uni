#pragma once
#include "EasyGraphics.h"
#include "TurtleCanvas.h"
#include "CommandList.h";

class TurtleWindow : public EasyGraphics
{
public:
	TurtleWindow();
	~TurtleWindow();

protected:
	virtual void onCreate();
	virtual void onDraw();
	virtual void onSize(UINT nType, int cx, int cy);

	//virtual void onChar(UINT nChar, UINT nRepCnt, UINT nFlags)
	//{
	//	static int count = 0;
	//	turtle->forward(5);
	//	turtle->rotate(2);
	//	++count;
	//	if ((count % 180) == 0)
	//	{
	//		turtle->rotate(4);
	//	}
	//	onDraw();
	//}



private:
	TurtleCanvas* turtle;
	CommandList* commands;
};