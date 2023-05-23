#pragma once
#include "EasyGraphics.h"
class Ball
{
public:
	Ball();
	~Ball();

	void move();
	void bounce(int axis);
	void draw(EasyGraphics* canvas);

	static Ball *getInstance();

	RECT getHitBox();

private:
	static Ball* instance;
	int x, y, dx, dy, radius;
	RECT hitBox;
};

inline RECT Ball::getHitBox() { return hitBox; }