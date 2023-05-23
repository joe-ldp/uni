#pragma once
#include "EasyGraphics.h"
class Paddle
{
public:
	Paddle();
	~Paddle();

	void draw(EasyGraphics* canvas);
	
	void updatePos(int x, int max);

	static Paddle *getInstance();

	RECT getHitBox();

private:
	static Paddle* instance;
	int x;
	const int y = 540;
	const int PADDLE_WIDTH = 150;
	const int PADDLE_HEIGHT = 10;
	RECT hitBox;

};

inline RECT Paddle::getHitBox() { return hitBox; }