#pragma once
#include "EasyGraphics.h"
#include "Ball.h"
#include "Block.h"
#include "Paddle.h"
#include <vector>
#include <stdlib.h>
#include <algorithm>

using namespace std;

class Breakout : public EasyGraphics
{
public:
	Breakout();
	~Breakout();

private:
	virtual void onCreate();
	virtual void onMouseMove(UINT nFlags, int x, int y);
	virtual void onTimer(UINT id);
	virtual void onDraw();
	virtual void onSize(UINT nType, int cx, int cy);
	virtual void onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags);

	void nextLevel();
	void generateLevel();
	void startGame();

	int hitTest(RECT rect1, RECT rect2);

	Ball* ball;
	Paddle* paddle;
	vector<vector<Block*>*> blocks;

	bool gameStarted = false;
	int windowWidth, windowHeight;
	int startX = 50, startY = 70;
};

inline void Breakout::nextLevel()
{
	generateLevel();
}

inline int Breakout::hitTest(RECT rect1, RECT rect2)
{
	if (rect1.left < rect2.right &&
		rect1.right > rect2.left &&
		rect1.top < rect2.bottom &&
		rect1.bottom > rect2.top)
	{
		if (rect1.left < rect2.right) return 2; // done
		if (rect1.right > rect2.left) return 1;
		if (rect1.top < rect2.bottom) return 3;
		if (rect1.bottom > rect2.top) return 4;
	}
	else
	{
		return 0;
	}
}